package week.pro.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.dto.BoardRequestDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "board")
    private List<Likes> likes = new ArrayList<>();

    @Builder
    public Board(String content){
        this.content = content;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void updateBoard(BoardRequestDto boardRequestDto){
        this.content = boardRequestDto.getContent();
    }
}
