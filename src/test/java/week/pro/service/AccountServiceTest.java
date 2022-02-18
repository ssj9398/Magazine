package week.pro.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.dto.AccountRequestDto;
import week.pro.repository.AccountRepository;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void 회원가입(){
        //given
        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "ab@google.com", "1234");

        //when
        Long saveUser = accountService.addUser(accountRequestDto);
        Optional<Account> findUser = accountRepository.findById(saveUser);

        //then
        em.flush();
        //assertEquals(accountRequestDto, accountRepository.findById(saveUser).get());
        assertThat(saveUser).isEqualTo(findUser.get().getId());
    }

    @Test
    public void 중복회원가입(){

        //given
        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "ab@google.com", "1234");
        AccountRequestDto accountRequestDto2 = new AccountRequestDto("홍길동", "ab@google.com", "12345");

        //when
        //then
        String test = null;
        assertThrows(NullPointerException.class, () -> {
            accountService.addUser(accountRequestDto);
            accountService.addUser(accountRequestDto2);
        });
    }
}