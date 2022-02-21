package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import week.pro.model.Success;
import week.pro.service.LikeService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/board/{boardId}/like")
    public ResponseEntity<Success> likeAdd(@PathVariable Long boardId, Principal Principal){
        likeService.addLike(boardId, Principal.getName());
        return new ResponseEntity<>(new Success(true,"좋아요 등록 성공"), HttpStatus.OK);
    }

    @DeleteMapping("/board/{boardId}/like")
    public ResponseEntity<Success> likeRemove(@PathVariable Long boardId, Principal Principal){
        likeService.removeLike(boardId, Principal.getName());
        return new ResponseEntity<>(new Success(true,"좋아요 삭제 성공"), HttpStatus.OK);
    }
}
