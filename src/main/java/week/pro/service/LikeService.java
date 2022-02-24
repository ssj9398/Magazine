package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.ApiRequestException;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.domain.Likes;
import week.pro.repository.AccountRepository;
import week.pro.repository.BoardRepository;
import week.pro.repository.LikeRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    private final BoardRepository boardRepository;

    private final AccountRepository accountRepository;

    @Transactional
    public void addLike(Long boardId, String email){
        Optional<Board> findBoardId = boardRepository.findById(boardId);
        Optional<Account> findAccountId = accountRepository.findByEmail(email);
        Optional<Likes> findLikeId = likeRepository.findByBoardAndEmail(boardId, findAccountId.get().getId());
        if(findLikeId.isEmpty()){
            Likes likes = Likes.builder()
                    .account(findAccountId.get())
                    .board(findBoardId.get())
                    .build();
            likeRepository.save(likes);
        }else {
            throw new ApiRequestException("좋아요 등록 실패");
        }
    }

    @Transactional
    public void removeLike(Long boardId, String email){
        Optional<Account> findAccountId = accountRepository.findByEmail(email);
        Optional<Likes> findLikeId = likeRepository.findByBoardAndEmail(boardId, findAccountId.get().getId());
        likeRepository.deleteById(findLikeId.get().getId());
    }
}
