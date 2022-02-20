package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week.pro.domain.Board;
import week.pro.dto.BoardRequestDto;
import week.pro.dto.BoardResponseDto;
import week.pro.model.GetAllBoard;
import week.pro.model.GetBoard;
import week.pro.model.Success;
import week.pro.service.BoardService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseEntity<Success> boardAdd(@RequestBody BoardRequestDto boardRequestDto){
        boardService.addBoard(boardRequestDto);
        return new ResponseEntity<>(new Success(true,"게시글 등록 성공"), HttpStatus.OK);
    }

    @GetMapping("/api/board")
    public ResponseEntity<GetAllBoard> boardList(){
        List<BoardResponseDto> findAllBoard = boardService.findBoard().stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new GetAllBoard(true,"게시글 조회 성공",findAllBoard),HttpStatus.OK);
    }

    @GetMapping("/api/board/{boardId}")
    public ResponseEntity<GetBoard> boardDetails(@PathVariable Long boardId){
        List<Board.BoardDetailResponse> boardDetail = boardService.findBoardDetail(boardId).stream()
                .map(Board.BoardDetailResponse::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new GetBoard(true,"게시글 하나 조회 성공",boardDetail),HttpStatus.OK);
    }

    @PutMapping("/api/board/{boardId}")
    public ResponseEntity<Success> boardModify(@PathVariable Long boardId, @RequestBody Board.BoardModify boardModify){
        boardService.modifyBoard(boardId, boardModify);
        return new ResponseEntity<>(new Success(true,"게시글 수정 성공"),HttpStatus.OK);
    }

    @DeleteMapping("/api/board/{boardId}")
    public ResponseEntity<Success> boardRemove(@PathVariable Long boardId){
        boardService.removeBoard(boardId);
        return new ResponseEntity<>(new Success(true,"게시글 삭제 성공"),HttpStatus.OK);
    }

}
