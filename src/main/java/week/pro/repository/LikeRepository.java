package week.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import week.pro.domain.Likes;

public interface LikeRepository extends JpaRepository<Likes,Long> {
}
