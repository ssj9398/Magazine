package week.pro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.dto.BoardResponseDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllBoard {
    private boolean success;

    private String msg;

    private List<BoardResponseDto> data;
}
