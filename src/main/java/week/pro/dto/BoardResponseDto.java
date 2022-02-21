package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.domain.Likes;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {

    private Long board_id;

    private Long account_id;

    private String account_name;

    private String content;

    private LocalDateTime time;

    private int like;

    public BoardResponseDto(Board board){
        this.board_id = board.getId();
        this.account_id = board.getAccount().getId();
        this.account_name = board.getAccount().getName();
        this.content = board.getContent();
        this.time = board.getModifiedAt();
        this.like = board.getLikes().size();
    }
}
