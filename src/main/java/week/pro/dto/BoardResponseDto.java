package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Account;
import week.pro.domain.Board;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;

    private String content;

    private String account_email;

    private String account_name;

    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.content = board.getContent();
        this.account_email = board.getAccount().getEmail();
        this.account_name = board.getAccount().getName();
    }
}
