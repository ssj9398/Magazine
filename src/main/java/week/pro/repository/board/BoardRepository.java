package week.pro.repository.board;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import week.pro.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long>, BoardRepositoryCustom {
//    @Query("select b from Board b where b.account.id=:id")
//    Optional<Board> findByUser(@Param("id") Long id);
//
//    //@Cacheable("boards")
//    @Query("select distinct b from Board b left join fetch b.account")
//    List<Board> findAllBoard();
}
