package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.repository.AccountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Long addUser(AccountRequestDto accountRequestDto){
        Account account = Account.builder()
                .email(accountRequestDto.getEmail())
                .name(accountRequestDto.getName())
                .password(accountRequestDto.getPassword())
                .build();
        validateDuplicateAccount(account);
        accountRepository.save(account);
        return account.getId();
    }

    private void validateDuplicateAccount(Account account){
        Optional<Account> findAccount = accountRepository.findByEmail(account.getEmail());
        if(findAccount.isPresent()){
            throw new NullPointerException();
        }
    }

}
