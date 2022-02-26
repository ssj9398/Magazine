package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import week.pro.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @Query("select distinct b from Board b left join fetch b.account left join fetch b.likes")
    List<Board> findAllBoard();
}
