package week.pro.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import week.pro.dto.BoardPageResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBoardPage {
    private boolean success;

    private String msg;

    private Page<BoardPageResponseDto> data;
}