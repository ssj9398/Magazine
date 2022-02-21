package week.pro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Likes;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeResponseDto {

    private Long board_id;

    public LikeResponseDto(Likes likes) {
        this.board_id = likes.getBoard().getId();
    }
}
