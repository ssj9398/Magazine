package week.pro.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @BatchSize(size = 100)
    @OneToMany(mappedBy = "board")
    private List<Likes> likes = new ArrayList<>();

    @Builder
    public Board(String content){
        this.content = content;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void updateBoard(BoardModify boardModify){
        this.content = boardModify.getContent();
    }

    public void addLike(Likes likes) {
        this.likes.add(likes);
        likes.setBoard(this);

    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardDetailResponse{

        private Long board_id;

        private String content;

        private LocalDateTime time;

        public BoardDetailResponse(Board board){
            this.board_id = board.getId();
            this.content = board.getContent();
            this.time = board.getModifiedAt();
        }

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardModify{
        private String content;
    }
}
