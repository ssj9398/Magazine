package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week.pro.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
