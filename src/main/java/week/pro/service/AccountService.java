package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.dto.RegisterRequestDto;
import week.pro.repository.AccountRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void addUser(RegisterRequestDto registerRequestDto){
        Account account = Account.builder()
                .name(registerRequestDto.getAccount_name())
                .password(registerRequestDto.getPassword())
                .email(registerRequestDto.getAccount_email())
                .build();
        accountRepository.save(account);
    }

}
