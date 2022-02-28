package week.pro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Likes;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountLikeResponseDto {

    private Long account_id;

    public AccountLikeResponseDto(Likes likes) {
        this.account_id = likes.getAccount().getId();
    }
}
