package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.AccountResponseDto;
import week.pro.model.GetAccount;
import week.pro.model.Success;
import week.pro.service.AccountService;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/api/register")
    public ResponseEntity<Success> UserAdd(@RequestBody AccountRequestDto accountRequestDto){
        accountService.addUser(accountRequestDto);
        return new ResponseEntity<>(new Success(true,"회원 가입 완료"), HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<GetAccount> UserLogin(@RequestBody Account.Login login){
        AccountResponseDto loginUser = accountService.loginUser(login);
        return new ResponseEntity<>(new GetAccount(true,"로그인 성공",loginUser),HttpStatus.OK);
    }
}