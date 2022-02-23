package week.pro.repository.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import week.pro.domain.Board;
import week.pro.dto.BoardPageResponseDto;
import week.pro.dto.BoardResponseDto;

import java.util.List;

public interface BoardRepositoryCustom {

    List<Board> findAllBoard();

    Page<BoardPageResponseDto> findAllBoardPage(Pageable pageable);
}
