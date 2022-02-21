package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week.pro.domain.Board;
import week.pro.dto.BoardRequestDto;
import week.pro.dto.BoardResponseDto;
import week.pro.model.GetAllBoard;
import week.pro.model.Success;
import week.pro.service.BoardService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<Success> boardAdd(Principal Principal, @RequestBody BoardRequestDto boardRequestDto){
        boardService.addBoard(Principal.getName(),boardRequestDto);
        return new ResponseEntity<>(new Success(true,"게시글 등록 성공"), HttpStatus.OK);
    }

    @GetMapping("/board")
    public ResponseEntity<GetAllBoard> boardList(){
        List<BoardResponseDto> findAllBoard = boardService.findBoard();
        return new ResponseEntity<>(new GetAllBoard(true,"게시글 조회 성공",findAllBoard),HttpStatus.OK);
    }

    @PutMapping("/board/{boardId}")
    public ResponseEntity<Success> boardModify(@PathVariable Long boardId, @RequestBody Board.BoardModify boardModify){
        boardService.modifyBoard(boardId, boardModify);
        return new ResponseEntity<>(new Success(true,"게시글 수정 성공"),HttpStatus.OK);
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<Success> boardRemove(@PathVariable Long boardId){
        boardService.removeBoard(boardId);
        return new ResponseEntity<>(new Success(true,"게시글 삭제 성공"),HttpStatus.OK);
    }
}