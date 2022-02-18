package week.pro.advice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import week.pro.advice.exception.BoardNotFoundException;
import week.pro.advice.exception.UserNameDuplicateException;
import week.pro.advice.exception.UserNotFoundException;
import week.pro.model.Fail;

@RequiredArgsConstructor
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(UserNameDuplicateException.class)
    public ResponseEntity<Fail> UserNameDuplicateException(UserNameDuplicateException e) {
        return new ResponseEntity<>(new Fail("이미 존재하는 이메일 입니다."), HttpStatus.OK);
    }

    @ExceptionHandler(BoardNotFoundException.class)
    public ResponseEntity<Fail> BoardNotFoundException(BoardNotFoundException e) {
        return new ResponseEntity<>(new Fail("해당 게시글이 존재하지 않습니다. 해당 게시글이 존재하지 않거나 잘못된 요청입니다."), HttpStatus.OK);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Fail> UserNotFoundException(UserNotFoundException e) {
        return new ResponseEntity<>(new Fail("해당 사용자가 존재하지 않습니다."), HttpStatus.OK);
    }
}