package week.pro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Board;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBoard {

    private boolean success;

    private String msg;

    private List<Board.BoardDetailResponse> data;
}
