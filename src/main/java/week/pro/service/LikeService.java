package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.BoardNotFoundException;
import week.pro.advice.exception.UserNotFoundException;
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
    public Board addLike(Long boardId) {
        Optional<Board> findLikeId = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        Optional<Board> byUser = Optional.ofNullable(boardRepository.findByUser(findLikeId.get().getAccount().getId()).orElseThrow(UserNotFoundException::new));

        Likes likes = Likes.builder()
                .account(findLikeId.get().getAccount())
                .board(findLikeId.get())
                .build();
        likeRepository.save(likes);
        findLikeId.get().addLike(likes);
        return findLikeId.get();
    }

    @Transactional
    public void removeLike(Long boardId, Long accountId) {
        Optional<Board> findLikeId = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        Optional<Board> byUser = Optional.ofNullable(boardRepository.findByUser(accountId).orElseThrow(UserNotFoundException::new));
        likeRepository.deleteLike(boardId, accountId);
    }
}
