package week.pro.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetBoard {

    private boolean success;

    private String msg;

    private Long board_id;
}
