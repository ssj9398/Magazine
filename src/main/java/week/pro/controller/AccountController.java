package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week.pro.advice.GetLogin;
import week.pro.advice.Success;
import week.pro.dto.LoginRequestDto;
import week.pro.dto.LoginResponseDto;
import week.pro.dto.RegisterRequestDto;
import week.pro.service.AccountService;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<GetLogin> login(@RequestBody LoginRequestDto loginRequestDto) {
        LoginResponseDto loginResponseDto = accountService.loginUser(loginRequestDto);
        return new ResponseEntity<>(new GetLogin(true,"로그인 성공",loginResponseDto),HttpStatus.OK);

    }

    @PostMapping("/register")
    public ResponseEntity<Success> UserAdd(@RequestBody RegisterRequestDto registerRequestDto){
        accountService.addUser(registerRequestDto);
        return new ResponseEntity<>(new Success(true,"회원 가입 완료"), HttpStatus.OK);
    }
}