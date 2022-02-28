package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.ApiRequestException;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.dto.response.BoardPageResponseDto;
import week.pro.dto.request.BoardRequestDto;
import week.pro.dto.response.BoardResponseDto;
import week.pro.repository.board.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long addBoard(Account account, BoardRequestDto boardRequestDto){
        System.out.println("account = " + account);
//        if(account.getEmail().isEmpty()) {
//            throw new ApiRequestException("토큰이 존재하지 않거나 만료된 토큰입니다.");
//        }
            Long boardId = boardRepository.save(BoardRequestDto.toEntity(boardRequestDto, account)).getId();
        return boardId;
    }

    public List<BoardResponseDto> findAllBoard(){
        List<Board> allBoard = boardRepository.findAllBoard();
        return allBoard.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Board> modifyBoard(Long boardId, BoardRequestDto.BoardModify boardModify, Long accountId){
        boardValidation(boardId,accountId);
        Optional<Board> boardOne = boardRepository.findById(boardId);
        boardOne.get().updateBoard(boardModify);
        return boardOne;
    }

    @Transactional
    public void removeBoard(Long boardId, Long accountId){
        boardValidation(boardId,accountId);
        boardRepository.deleteById(boardId);
    }

    public Page<BoardPageResponseDto> findBoardPaging(Pageable pageable) {
        return boardRepository.findAllBoardPage(pageable);
    }

    private void boardValidation(Long boardId, Long accountId){
        Board findBoard = boardRepository.findById(boardId).orElseThrow(()
                -> new ApiRequestException("게시글이 존재하지 않습니다."));
        if(!findBoard.getAccount().getId().equals(accountId)){
            throw new ApiRequestException("게시글 작성자가 아닙니다.");
        }
    }
}
