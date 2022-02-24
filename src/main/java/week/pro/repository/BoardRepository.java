package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week.pro.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
