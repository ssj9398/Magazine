package week.pro.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import week.pro.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardRepositoryCustom {
    @Query("select distinct b from Board b left join fetch b.account left join fetch b.likes order by b.modifiedAt desc ")
    List<Board> findAllBoard();
}
