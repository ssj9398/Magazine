package week.pro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.AccountResponseDto;
import week.pro.dto.TokenDto;
import week.pro.jwt.JwtFilter;
import week.pro.jwt.TokenProvider;
import week.pro.model.GetAccount;
import week.pro.model.Success;
import week.pro.service.AccountService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AccountService accountService;


    @PostMapping("/api/register")
    public ResponseEntity<Success> UserAdd(@RequestBody AccountRequestDto accountRequestDto){
        accountService.addUser(accountRequestDto);
        return new ResponseEntity<>(new Success(true,"회원 가입 완료"), HttpStatus.OK);
    }

    @PostMapping("/api/login")
    public ResponseEntity<GetAccount> UserLogin(@Valid @RequestBody Account.Login login){
        AccountResponseDto loginUser = accountService.loginUser(login);
        System.out.println("loginUser" +loginUser);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getAccount_email(), login.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);
        loginUser.setToken(jwt);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new GetAccount(true,"로그인 성공",loginUser), httpHeaders, HttpStatus.OK);
    }
}