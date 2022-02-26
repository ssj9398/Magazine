package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import week.pro.advice.Success;
import week.pro.domain.Account;
import week.pro.service.LikeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/board/{boardId}/like")
    public ResponseEntity<Success> likeAdd(@PathVariable Long boardId,@AuthenticationPrincipal Account account){
        likeService.addLike(boardId,account.getId());
        return new ResponseEntity<>(new Success(true,"좋아요 등록 성공"), HttpStatus.OK);
    }

    @DeleteMapping("/board/{boardId}/like")
    public ResponseEntity<Success> likeRemove(@PathVariable Long boardId,@AuthenticationPrincipal Account account){
        likeService.removeLike(boardId,account.getId());
        return new ResponseEntity<>(new Success(true,"좋아요 삭제 성공"), HttpStatus.OK);
    }
}
