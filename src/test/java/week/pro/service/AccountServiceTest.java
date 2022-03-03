package week.pro.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.dto.request.LoginRequestDto;
import week.pro.dto.request.RegisterRequestDto;
import week.pro.dto.response.LoginResponseDto;
import week.pro.jwt.JwtTokenProvider;
import week.pro.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("account")
@SpringBootTest
@Transactional
class AccountServiceTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    void addUser() {
        //given
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .account_email("test@google.com")
                .account_name("abcde")
                .password("123456")
                .password_check("123456")
                .build();

        Account account = null;

        //when
        accountService.addUser(registerRequestDto,account);
        List<Account> all = accountRepository.findAll();
        List<String> collect = all.stream().map(Account::getEmail).collect(Collectors.toList());

        //then
        Assertions.assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void loginUser() {
        //given
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .account_email("test@google.com")
                .account_name("abcde")
                .password("123456")
                .password_check("123456")
                .build();

        Account account = null;
        accountService.addUser(registerRequestDto,account);

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .account_email("test@google.com")
                        .password("123456")
                                .build();
        //when
        LoginResponseDto loginResponseDto = accountService.loginUser(loginRequestDto, account);
        String token = loginResponseDto.getToken();

        //then
        Assertions.assertThat(loginResponseDto.getAccount_email()).isEqualTo("test@google.com");
        Assertions.assertThat(token).isNotEmpty();

    }

    @Test
    void findUser() {
    }
}