package week.pro.repository.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import week.pro.dto.response.BoardPageResponseDto;

public interface BoardRepositoryCustom {

    Page<BoardPageResponseDto> findAllBoardPage(Pageable pageable);
}
