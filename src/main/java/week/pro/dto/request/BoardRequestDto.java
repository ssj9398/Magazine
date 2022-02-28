package week.pro.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.domain.Account;
import week.pro.domain.Board;

@Getter
@NoArgsConstructor
public class BoardRequestDto {

    private String content;

    private String img_url;

    private String board_status;

    @Builder
    public BoardRequestDto(String content, String img_url, String board_status){
        this.content = content;
        this.img_url = img_url;
        this.board_status = board_status;
    }

    public static Board toEntity(BoardRequestDto boardRequestDto, Account account){
        return Board.builder()
                .img_url(boardRequestDto.getImg_url())
                .account(account)
                .contents(boardRequestDto.content)
                .board_status(boardRequestDto.getBoard_status())
                .build();
    }

    @Getter
    @NoArgsConstructor
    public static class BoardModify{
        private String content;
        private String img_url;
        private String board_status;
    }
}
