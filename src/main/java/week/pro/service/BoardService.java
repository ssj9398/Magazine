package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.domain.Board;
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
    public Long addBoard(Account account, BoardRequestDto boardRequestDto){
        Long boardId = boardRepository.save(BoardRequestDto.toEntity(boardRequestDto, account)).getId();
        return boardId;
    }

    public List<BoardResponseDto> findAllBoard(){
        List<Board> allBoard = boardRepository.findAll();
        return allBoard.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Board> modifyBoard(Long boardId, BoardRequestDto.BoardModify boardModify){
        Optional<Board> boardOne = boardRepository.findById(boardId);
        boardOne.get().updateBoard(boardModify);
        return boardOne;
    }

}
