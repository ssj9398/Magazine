package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Account;
import week.pro.domain.Likes;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {

    private Long account_id;

    private String account_email;

    private String account_name;

     private String token;

     private List<LikeResponseDto> like_board;

    public AccountResponseDto(Account account){
        this.account_id = account.getId();
        this.account_email = account.getEmail();
        this.account_name = account.getName();
        this.like_board = account.getLikes().stream()
                .map(LikeResponseDto::new)
                .collect(Collectors.toList());
    }
}
