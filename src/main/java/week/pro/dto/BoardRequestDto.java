package week.pro.dto;

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

    @Builder
    public BoardRequestDto(String content, String img_url){
        this.content = content;
        this.img_url = img_url;
    }

    public static Board toEntity(BoardRequestDto boardRequestDto, Account account){
        return Board.builder()
                .img_url(boardRequestDto.getImg_url())
                .account(account)
                .contents(boardRequestDto.content)
                .build();
    }
}
