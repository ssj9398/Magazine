package week.pro.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import week.pro.domain.Account;
import week.pro.dto.AccountResponseDto;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<AccountResponseDto> findByEmail(String email);

    @EntityGraph(attributePaths = "authorities")
    Optional<Account> findOneWithAuthoritiesByEmail(String email);
}
