package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.BoardNotFoundException;
import week.pro.advice.exception.UserNotFoundException;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.dto.AccountResponseDto;
import week.pro.dto.BoardRequestDto;
import week.pro.dto.BoardResponseDto;
import week.pro.repository.AccountRepository;
import week.pro.repository.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    private final AccountRepository accountRepository;

    @Transactional
    public Long addBoard(String email, BoardRequestDto boardRequestDto) {
        Optional<Account> findUserEmail = Optional.ofNullable(accountRepository.findEmail(email).orElseThrow(UserNotFoundException::new));
        Board board = Board.builder()
                .content(boardRequestDto.getContent())
                .img_url(boardRequestDto.getImg_url())
                .build();
        boardRepository.save(board);
        findUserEmail.get().addBoard(board);
        return board.getId();
    }

    public List<BoardResponseDto> findBoard() {
        return boardRepository.findAllBoard().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Board> modifyBoard(Long boardId, Board.BoardModify boardModify) {
        Optional<Board> findOneBoard = Optional.ofNullable(boardRepository.findById(boardId).orElseThrow(BoardNotFoundException::new));
        findOneBoard.get().updateBoard(boardModify);
        return findOneBoard;
    }

    @Transactional
    public void removeBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }
}
