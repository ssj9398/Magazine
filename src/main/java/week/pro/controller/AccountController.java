package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week.pro.dto.AccountRequestDto;
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
    public Long UserLogin(@RequestBody AccountRequestDto accountRequestDto){
        Long loginUser = accountService.loginUser(accountRequestDto);

        return loginUser;
    }
}