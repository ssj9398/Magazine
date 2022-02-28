package week.pro.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import week.pro.dto.request.BoardRequestDto;

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
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String img_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes= new ArrayList<>();

    private String board_status;

    @Builder
    public Board(String contents, String img_url, Account account, String board_status){
        this.contents = contents;
        this.img_url = img_url;
        this.account = account;
        this.board_status = board_status;
    }

    public void updateBoard(BoardRequestDto boardRequestDto) {
        this.contents = boardRequestDto.getContent();
        this.board_status = boardRequestDto.getBoard_status();
        this.img_url = boardRequestDto.getImg_url();
    }
}
