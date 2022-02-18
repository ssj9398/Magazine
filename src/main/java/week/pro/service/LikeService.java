package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public void addLike(Long boardId) {
        Optional<Board> findLikeId = boardRepository.findById(boardId);
        Likes likes = Likes.builder()
                .account(findLikeId.get().getAccount())
                .board(findLikeId.get())
                .build();
        likeRepository.save(likes);
        findLikeId.get().addLike(likes);
    }
}
