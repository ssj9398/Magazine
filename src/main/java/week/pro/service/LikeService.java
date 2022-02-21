package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.BoardNotFoundException;
import week.pro.advice.exception.LikeBoardCreateException;
import week.pro.advice.exception.LikeNotFoundException;
import week.pro.advice.exception.UserNotFoundException;
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
    public Board addLike(Long boardId, String email) {
        Optional<Board> findLikeId = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        Optional<Account> findEmail = Optional.ofNullable(accountRepository.findEmail(email).orElseThrow(UserNotFoundException::new));
        Optional<Likes> boardIdAndAccount = likeRepository.findByboardIdAccount(boardId, findEmail.get().getId());

        if(boardIdAndAccount.isEmpty()) {
            Likes likes = Likes.builder()
                    .account(findLikeId.get().getAccount())
                    .board(findLikeId.get())
                    .build();
            likeRepository.save(likes);
            findEmail.get().addLike(likes);
            findLikeId.get().addLike(likes);
        }else {
            throw new LikeBoardCreateException();
        }
        return findLikeId.get();
    }

    @Transactional
    public void removeLike(Long boardId, String email) {
        Optional<Account> findEmail = Optional.ofNullable(accountRepository.findEmail(email).orElseThrow(UserNotFoundException::new));
        Optional<Likes> boardIdAndAccount = Optional.ofNullable(likeRepository.findByboardIdAccount(boardId, findEmail.get().getId()).orElseThrow(LikeNotFoundException::new));
        likeRepository.deleteLike(boardId, findEmail.get().getId());
    }
}
