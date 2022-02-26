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
    public void addUser(RegisterRequestDto registerRequestDto, Account account) {
        accountvalidation(registerRequestDto, account);
        Optional<Account> findUserByEmail = accountRepository.findByEmail(registerRequestDto.getAccount_email());
        if (findUserByEmail.isEmpty()) {
            account = Account.builder()
                    .name(registerRequestDto.getAccount_name())
                    .password(passwordEncoder.encode(registerRequestDto.getPassword()))
                    .email(registerRequestDto.getAccount_email())
                    .build();
            accountRepository.save(account);
        } else
            throw new ApiRequestException("이미 존재하는 사용자 입니다.");
    }

    public LoginResponseDto loginUser(RegisterRequestDto registerRequestDto, Account account) {
        accountvalidation(registerRequestDto, account);
        Optional<Account> findUserByEmail = accountRepository.findByEmail(registerRequestDto.getAccount_email());
        if (findUserByEmail.isEmpty()) {
            throw new ApiRequestException("존재 하지 않는 사용자 입니다.");
        } else if (!passwordEncoder.matches(registerRequestDto.getPassword(), findUserByEmail.get().getPassword())) {
            throw new ApiRequestException("비밀번호 틀림");
        }
        String token = jwtTokenProvider.createToken(registerRequestDto.getAccount_email());
        LoginResponseDto loginResponseDto = accountRepository.login(registerRequestDto.getAccount_email());
        loginResponseDto.setToken(token);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + token);
        return loginResponseDto;
    }

    public void accountvalidation(RegisterRequestDto registerRequestDto, Account account) {
        String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        if (account != null) {
            throw new ApiRequestException("이미 로그인 되있음");
        } else if (!Objects.equals(registerRequestDto.getPassword(), registerRequestDto.getPassword_check()) ||
                registerRequestDto.getPassword().contains(registerRequestDto.getAccount_name()) ||
                registerRequestDto.getPassword().length() < 4) {
            throw new ApiRequestException("비밀번호 조건을 맞춰주세요.");
        } else if (!Pattern.matches("^[a-zA-Z0-9]{3,}$", registerRequestDto.getAccount_name()) ||
                registerRequestDto.getAccount_name().length() < 3) {
            throw new ApiRequestException("닉네임 조건을 맞춰주세요.");
        }
        else if(!Pattern.matches(emailPattern, registerRequestDto.getAccount_email())) {
            throw new ApiRequestException("올바른 이메일 형식이 아닙니다.");
        }

    }
}
