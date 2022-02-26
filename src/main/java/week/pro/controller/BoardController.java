package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import week.pro.advice.GetAllBoard;
import week.pro.advice.GetBoard;
import week.pro.domain.Account;
import week.pro.dto.BoardRequestDto;
import week.pro.dto.BoardResponseDto;
import week.pro.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<GetBoard> boardAdd(@RequestBody BoardRequestDto boardRequestDto,
                                             @AuthenticationPrincipal Account account){
        Long oneBoard = boardService.addBoard(account, boardRequestDto);
        return new ResponseEntity<>(new GetBoard(true,"게시글 등록 성공",oneBoard), HttpStatus.OK);
    }

    @GetMapping("/board")
    public ResponseEntity<GetAllBoard> AllBoardList(){
        List<BoardResponseDto> findAllBoard = boardService.findAllBoard();
        return new ResponseEntity<>(new GetAllBoard(true, "전체 게시글 조회 성공", findAllBoard),HttpStatus.OK);
    }
}
