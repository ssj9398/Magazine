package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.ApiRequestException;
import week.pro.advice.exception.UserNameDuplicateException;
import week.pro.advice.exception.UserNotFoundException;
import week.pro.domain.Account;
import week.pro.domain.Authority;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.AccountResponseDto;
import week.pro.repository.AccountRepository;

import java.util.Collections;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public void addUser(AccountRequestDto accountRequestDto){
        validateAccount(accountRequestDto);
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

            Account account = Account.builder()
                    .email(accountRequestDto.getAccount_email())
                    .name(accountRequestDto.getAccount_name())
                    .password(encoder.encode(accountRequestDto.getPassword()))
                    .activated(true)
                    .authorities(Collections.singleton(authority))
                    .build();

            accountRepository.save(account);
    }

    private void validateAccount(AccountRequestDto accountRequestDto){
        Optional<AccountResponseDto> findUser = accountRepository.findByEmail(accountRequestDto.getAccount_email());
        if(findUser.isPresent()){
            throw new UserNameDuplicateException();
        }
        if(!Objects.equals(accountRequestDto.getPassword(), accountRequestDto.getCheck_password())||accountRequestDto.getPassword().equals(accountRequestDto.getAccount_name())){
            throw new ApiRequestException("비밀번호 조건을 맞춰주세요.");
        }
        if(!Pattern.matches("^[a-zA-Z0-9]{3,}$",accountRequestDto.getAccount_name())){
            throw new ApiRequestException("닉네임 조건을 맞춰주세요.");
        }
    }

    public AccountResponseDto loginUser(Account.Login login) {
        Optional<AccountResponseDto> findUser = Optional.ofNullable(accountRepository.findByEmail(login.getAccount_email())).orElseThrow(UserNotFoundException::new);
        return findUser.get();
    }
}
