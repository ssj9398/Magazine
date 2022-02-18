package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import week.pro.model.Success;
import week.pro.service.LikeService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/api/board/{boardId}/like")
    public ResponseEntity<Success> likeAdd(@PathVariable Long boardId){
        likeService.addLike(boardId);
        return new ResponseEntity<>(new Success(true,"좋아요 등록 성공"), HttpStatus.OK);
    }

    @DeleteMapping("/api/board/{boardId}/like/{accountId}")
    public ResponseEntity<Success> likeRemove(@PathVariable Long accountId, @PathVariable Long boardId){
        likeService.removeLike(boardId,accountId);
        return new ResponseEntity<>(new Success(true,"좋아요 삭제 성공"), HttpStatus.OK);
    }
}
