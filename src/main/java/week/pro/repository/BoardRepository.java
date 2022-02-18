package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import week.pro.domain.Board;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("select b from Board b where b.account.id=:id")
    Optional<Board> findByUser(@Param("id") Long id);
}
