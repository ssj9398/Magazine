package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import week.pro.domain.Account;
import week.pro.dto.response.LoginResponseDto;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(@Param("account_email") String account_email);

    @Query("select distinct a from Account a left join fetch a.likes where a.email=:email")
    LoginResponseDto login(@Param("email") String email);
}
