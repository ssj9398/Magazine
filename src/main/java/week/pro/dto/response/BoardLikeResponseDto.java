package week.pro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.domain.Likes;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardLikeResponseDto {

    private Long board_id;

    public BoardLikeResponseDto(Likes likes) {
        this.board_id = likes.getBoard().getId();
    }
}
