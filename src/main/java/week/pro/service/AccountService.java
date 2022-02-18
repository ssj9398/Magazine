package week.pro.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.repository.AccountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
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
        Optional<Account> findUser = accountRepository.findByEmail(account.getEmail());
        if(findUser.isPresent()){
            throw new NullPointerException();
        }
    }

    public Long loginUser(AccountRequestDto accountRequestDto) {
        Optional<Account> findUser = Optional.ofNullable(accountRepository.findByEmail(accountRequestDto.getEmail()).orElseThrow(NullPointerException::new));
        return findUser.get().getId();
    }
}
