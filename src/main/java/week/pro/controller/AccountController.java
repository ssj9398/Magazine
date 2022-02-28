package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week.pro.advice.GetLogin;
import week.pro.advice.Success;
import week.pro.domain.Account;
import week.pro.dto.request.LoginRequestDto;
import week.pro.dto.response.LoginResponseDto;
import week.pro.dto.request.RegisterRequestDto;
import week.pro.jwt.UserDetailsImpl;
import week.pro.service.AccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<GetLogin> login(@RequestBody LoginRequestDto loginRequestDto,
                                          @AuthenticationPrincipal Account account) {
        LoginResponseDto loginResponseDto = accountService.loginUser(loginRequestDto, account);
        return new ResponseEntity<>(new GetLogin(true, "로그인 성공", loginResponseDto), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Success> UserAdd(@RequestBody RegisterRequestDto registerRequestDto,
                                           @AuthenticationPrincipal Account account) {
        accountService.addUser(registerRequestDto, account);
        return new ResponseEntity<>(new Success(true, "회원 가입 완료"), HttpStatus.OK);
    }
}