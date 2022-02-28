package week.pro.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.domain.Board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardResponseDto {

    private Long board_id;

    private String img_url;

    private Long account_id;

    private String account_name;

    private String content;

    private LocalDateTime time;

    private String board_status;

    private int like;

    private List<AccountLikeResponseDto> like_account;

    public BoardResponseDto(Board board){
        this.board_id = board.getId();
        this.img_url = board.getImg_url();
        this.account_id = board.getAccount().getId();
        this.account_name = board.getAccount().getName();
        this.content = board.getContents();
        this.time = board.getModifiedAt();
        this.like = board.getLikes().size();
        this.board_status= board.getBoard_status();
        this.like_account = board.getLikes().stream()
                .map(AccountLikeResponseDto::new)
                .collect(Collectors.toList());
    }
}
