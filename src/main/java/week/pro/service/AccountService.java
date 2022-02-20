package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.advice.exception.UserNameDuplicateException;
import week.pro.advice.exception.UserNotFoundException;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.AccountResponseDto;
import week.pro.repository.AccountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder encoder;

    @Transactional
    public Long addUser(AccountRequestDto accountRequestDto){
        Account account = Account.builder()
                .email(accountRequestDto.getAccount_email())
                .name(accountRequestDto.getAccount_name())
                .password(encoder.encode(accountRequestDto.getPassword()))
                .activated(true)
                .build();
        validateDuplicateAccount(account);
        accountRepository.save(account);
        return account.getId();
    }

    private void validateDuplicateAccount(Account account){
        Optional<AccountResponseDto> findUser = accountRepository.findByEmail(account.getEmail());
        if(findUser.isPresent()){
            throw new UserNameDuplicateException();
        }
    }

    public AccountResponseDto loginUser(Account.Login login) {
        Optional<AccountResponseDto> findUser = Optional.ofNullable(accountRepository.findByEmail(login.getAccount_email())).orElseThrow(UserNotFoundException::new);
        return findUser.get();
    }
}
