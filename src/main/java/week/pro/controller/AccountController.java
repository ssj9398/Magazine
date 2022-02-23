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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week.pro.advice.exception.ApiRequestException;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.AccountResponseDto;
import week.pro.jwt.JwtFilter;
import week.pro.jwt.TokenProvider;
import week.pro.model.GetAccount;
import week.pro.model.Success;
import week.pro.service.AccountService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AccountController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AccountService accountService;


    @PostMapping("/register")
    public ResponseEntity<Success> UserAdd(@RequestBody AccountRequestDto accountRequestDto, Principal principal){
        accountService.addUser(accountRequestDto);
        return new ResponseEntity<>(new Success(true,"회원 가입 완료"), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<GetAccount> UserLogin(@Valid @RequestBody Account.Login login, Principal principal){
//        System.out.println("principal" + principal.getName());
//        if(principal != null){
//            throw new ApiRequestException("이미 로그인 되어있습니다.");
//        }
        AccountResponseDto loginUser = accountService.loginUser(login);

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