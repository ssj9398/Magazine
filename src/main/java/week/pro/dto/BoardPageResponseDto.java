package week.pro.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.domain.Likes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageResponseDto {

    private Long board_id;

    private String image_url;

    private Long account_id;

    private String account_name;

    private String contents;

    private LocalDateTime insert_dt;

    private String layout;

    private int like_cnt;

    @QueryProjection
    public BoardPageResponseDto(Board board){
        this.board_id = board.getId();
        this.image_url = board.getImg_url();
        this.account_id = board.getAccount().getId();
        this.account_name = board.getAccount().getName();
        this.contents = board.getContent();
        this.insert_dt = board.getModifiedAt();
        this.like_cnt = board.getLikes().size();
        this.layout="bottom";
    }
}
