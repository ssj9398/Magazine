package week.pro.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.domain.Board;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

    private Long board_id;

    private String image_url;

    private Long account_id;

    private String account_name;

    private String contents;

    private LocalDateTime insert_dt;

    private String layout;

    private int like_cnt;

    public BoardResponseDto(Board board){
        this.board_id = board.getId();
        this.image_url = board.getImg_url();
        this.account_id = board.getAccount().getId();
        this.account_name = board.getAccount().getName();
        this.contents = board.getContents();
        this.insert_dt = board.getModifiedAt();
        this.like_cnt = board.getLikes().size();
        this.layout= board.getLayout();
    }
}
