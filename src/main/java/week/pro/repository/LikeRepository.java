package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import week.pro.domain.Likes;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes, Long> {

    @Query("select l from Likes l where l.board.id=:boardId and l.account.id=:accountId")
    Optional<Likes> findByBoardAndEmail(@Param("boardId") Long boardId,@Param("accountId") Long accountId);
}
