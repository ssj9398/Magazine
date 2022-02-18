package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.dto.BoardRequestDto;
import week.pro.repository.AccountRepository;
import week.pro.repository.BoardRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    private final AccountRepository accountRepository;

    @Transactional
    public Long addBoard(BoardRequestDto boardRequestDto) {
        Optional<Account> findUserEmail = accountRepository.findByEmail(boardRequestDto.getEmail());

        Board board = Board.builder()
                .content(boardRequestDto.getContent())
                .build();
        boardRepository.save(board);
        findUserEmail.get().addBoard(board);
        return board.getId();
    }

    public List<Board> findBoard() {
        List<Board> findAllBoard = boardRepository.findAll();
        return findAllBoard;
    }

    public Optional<Board> findBoardDetail(Long boardId) {
        Optional<Board> findBoardDetails = boardRepository.findById(boardId);
        return findBoardDetails;
    }


}
