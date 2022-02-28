package week.pro.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week.pro.domain.Account;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Setter
public class LoginResponseDto {

    private Long account_id;

    private String account_email;

    private String account_name;

    private String token;

    private List<BoardLikeResponseDto> like_board;

    public LoginResponseDto(Account account){
        this.account_id = account.getId();
        this.account_email = account.getEmail();
        this.account_name = account.getName();
        this.like_board = account.getLikes().stream()
                .map(BoardLikeResponseDto::new)
                .collect(Collectors.toList());
    }
}
