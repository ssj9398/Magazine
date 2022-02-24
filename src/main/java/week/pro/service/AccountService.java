package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.ApiRequestException;
import week.pro.domain.Account;
import week.pro.dto.LoginRequestDto;
import week.pro.dto.LoginResponseDto;
import week.pro.dto.RegisterRequestDto;
import week.pro.jwt.JwtTokenProvider;
import week.pro.repository.AccountRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void addUser(RegisterRequestDto registerRequestDto){
        Account account = Account.builder()
                .name(registerRequestDto.getAccount_name())
                .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                .email(registerRequestDto.getAccount_email())
                .build();
        accountRepository.save(account);
    }

    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
        if(!Objects.equals(loginRequestDto.getPassword(), loginRequestDto.getCheck_password())||loginRequestDto.getPassword().contains(loginRequestDto.getAccount_name())){
            throw new ApiRequestException("비밀번호 조건을 맞춰주세요.");
        }
        if(!Pattern.matches("^[a-zA-Z0-9]{3,}$", loginRequestDto.getAccount_name())){
            throw new ApiRequestException("닉네임 조건을 맞춰주세요.");
        }
        String token = jwtTokenProvider.createToken(loginRequestDto.getAccount_email());
        LoginResponseDto loginResponseDto = accountRepository.login(loginRequestDto);
        loginResponseDto.setToken(token);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        return loginResponseDto;

    }
}
