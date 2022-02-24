package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import week.pro.domain.Account;
import week.pro.dto.LoginRequestDto;
import week.pro.dto.LoginResponseDto;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String account_email);

    @Query("select distinct a from Account a left join fetch a.likes")
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
