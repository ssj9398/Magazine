package week.pro.dto.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.domain.Board;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageResponseDto {

    private Long board_id;

    private String image_url;

    private Long account_id;

    private String account_name;

    private String content;

    private LocalDateTime time;

    private String board_status;

    private int like_cnt;

    @QueryProjection
    public BoardPageResponseDto(Board board){
        this.board_id = board.getId();
        this.image_url = board.getImg_url();
        this.account_id = board.getAccount().getId();
        this.account_name = board.getAccount().getName();
        this.content = board.getContents();
        this.time = board.getModifiedAt();
        this.like_cnt = board.getLikes().size();
        this.board_status= board.getBoard_status();
    }
}
