package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import week.pro.domain.Likes;

public interface LikeRepository extends JpaRepository<Likes,Long> {
    @Modifying
    @Query("delete from Likes l where l.board.id=:boardId and l.account.id = :accountId")
    void deleteLike(@Param("boardId") Long boardId,@Param("accountId") Long accountId);
}
