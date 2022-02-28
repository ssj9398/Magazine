package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import week.pro.advice.GetAllBoard;
import week.pro.advice.GetBoard;
import week.pro.advice.GetBoardPage;
import week.pro.advice.Success;
import week.pro.dto.response.BoardPageResponseDto;
import week.pro.dto.request.BoardRequestDto;
import week.pro.dto.response.BoardResponseDto;
import week.pro.jwt.UserDetailsImpl;
import week.pro.service.BoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<GetBoard> boardAdd(@RequestBody BoardRequestDto boardRequestDto,
                                             @AuthenticationPrincipal UserDetailsImpl account){
        Long oneBoard = boardService.addBoard(account.getUser(), boardRequestDto);
        return new ResponseEntity<>(new GetBoard(true,"게시글 등록 성공",oneBoard), HttpStatus.OK);
    }

    @GetMapping("/board")
    public ResponseEntity<GetAllBoard> AllBoardList(){
        List<BoardResponseDto> findAllBoard = boardService.findAllBoard();
        return new ResponseEntity<>(new GetAllBoard(true, "전체 게시글 조회 성공", findAllBoard),HttpStatus.OK);
    }

    @GetMapping("/boardPaging")
    public ResponseEntity<GetBoardPage> BoardPaging(Pageable pageable){
        Page<BoardPageResponseDto> boardPaging = boardService.findBoardPaging(pageable);
        return new ResponseEntity<>(new GetBoardPage(true,"게시글 페이징",boardPaging),HttpStatus.OK);
    }

    @PutMapping("/board/{boardId}")
    public ResponseEntity<Success> boardModify(@PathVariable Long boardId,
                                               @RequestBody BoardRequestDto boardRequestDto,
                                               @AuthenticationPrincipal UserDetailsImpl account){
        boardService.modifyBoard(boardId, boardRequestDto, account.getUser().getId());
        return new ResponseEntity<>(new Success(true,"게시글 수정 성공"),HttpStatus.OK);
    }

    @DeleteMapping("/board/{boardId}")
    public ResponseEntity<Success> boardRemove(@PathVariable Long boardId,
                                               @AuthenticationPrincipal UserDetailsImpl account){
        boardService.removeBoard(boardId, account.getUser().getId());
        return new ResponseEntity<>(new Success(true,"게시글 삭제 성공"),HttpStatus.OK);
    }
}
