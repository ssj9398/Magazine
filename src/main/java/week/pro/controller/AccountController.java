package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import week.pro.advice.GetLogin;
import week.pro.advice.Success;
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
                                          UserDetailsImpl account) {
        LoginResponseDto loginResponseDto = accountService.loginUser(loginRequestDto, account.getUser());
        return new ResponseEntity<>(new GetLogin(true, "로그인 성공", loginResponseDto), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Success> UserAdd(@RequestBody RegisterRequestDto registerRequestDto,
                                           UserDetailsImpl account) {
        accountService.addUser(registerRequestDto, account.getUser());
        return new ResponseEntity<>(new Success(true, "회원 가입 완료"), HttpStatus.OK);
    }
    //토큰만 받아서 사용자 정보 주기
    @GetMapping("/token")
    public ResponseEntity<GetLogin> token(@AuthenticationPrincipal UserDetailsImpl account){
        System.out.println("account = " + account.getUser().getId());
        LoginResponseDto user = accountService.findUser(account.getUser().getEmail());
        return new ResponseEntity<>(new GetLogin(true, "사용자 정보", user), HttpStatus.OK);
        //return new ResponseEntity<>(new TokenResponseDto(true, "회원 가입 완료",authentication), HttpStatus.OK);
    }
}