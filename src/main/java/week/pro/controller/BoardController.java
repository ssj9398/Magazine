package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week.pro.advice.GetBoard;
import week.pro.dto.BoardRequestDto;
import week.pro.jwt.UserDetailsImpl;
import week.pro.service.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<GetBoard> boardAdd(Authentication authentication, @RequestBody BoardRequestDto boardRequestDto){
        System.out.println("userDetails.getUser()" + authentication.getAuthorities());
        System.out.println(authentication.getName());
        System.out.println(authentication.getPrincipal());
        System.out.println("aaaaaaaaaaaaaaaa");
        //Long oneBoard = boardService.addBoard(userDetails.getUser(), boardRequestDto);

        return new ResponseEntity<>(new GetBoard(true,"게시글 등록 성공",1L), HttpStatus.OK);
    }
}
