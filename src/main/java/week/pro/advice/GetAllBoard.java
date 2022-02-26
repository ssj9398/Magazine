package week.pro.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.dto.BoardResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GetAllBoard {

    private boolean success;

    private String msg;

    private List<BoardResponseDto> data;
}
