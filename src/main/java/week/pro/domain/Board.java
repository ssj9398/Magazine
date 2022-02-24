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
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String img_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "board")
    private List<Likes> likes= new ArrayList<>();

    private String layout;

    @Builder
    public Board(String contents, String img_url, Account account, String layout){
        this.contents = contents;
        this.img_url = img_url;
        this.account = account;
        this.layout = layout;
    }

    public void updateBoard(BoardRequestDto.BoardModify boardModify) {
        this.contents = boardModify.getContent();
        this.layout = boardModify.getLayout();
        this.img_url = boardModify.getImg_url();
    }
}
