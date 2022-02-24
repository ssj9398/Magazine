package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import java.util.stream.Collectors;

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
        Optional<Account> findUserByEmail = accountRepository.findByEmail(loginRequestDto.getAccount_email());
        System.out.println("findUserByEmail" + findUserByEmail.get().getEmail());
        if(!Objects.equals(loginRequestDto.getPassword(), loginRequestDto.getCheck_password())||loginRequestDto.getPassword().contains(loginRequestDto.getAccount_name())){
            throw new ApiRequestException("비밀번호 조건을 맞춰주세요.");
        }
        if(!Pattern.matches("^[a-zA-Z0-9]{3,}$", loginRequestDto.getAccount_name())){
            throw new ApiRequestException("닉네임 조건을 맞춰주세요.");
        }
        String token = jwtTokenProvider.createToken(loginRequestDto.getAccount_email());
        System.out.println("token" + token);
        LoginResponseDto loginResponseDto = accountRepository.login(loginRequestDto);
        loginResponseDto.setToken(token);
        return loginResponseDto;

    }
}
