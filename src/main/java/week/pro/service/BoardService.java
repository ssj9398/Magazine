package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.BoardNotFoundException;
import week.pro.advice.exception.UserNotFoundException;
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
        Optional<Account> findUserEmail = Optional.ofNullable(accountRepository.findByEmail(boardRequestDto.getEmail()).orElseThrow(UserNotFoundException::new));

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
        Optional<Board> findBoardDetails = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        return findBoardDetails;
    }

    @Transactional
    public Optional<Board> modifyBoard(Long boardId, BoardRequestDto boardRequestDto) {
        Optional<Board> findOneBoard = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        findOneBoard.get().updateBoard(boardRequestDto);
        return findOneBoard;
    }

    @Transactional
    public void removeBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
