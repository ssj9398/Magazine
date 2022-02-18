package week.pro.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_name")
    private String name;

    @Email
    @Column(name = "account_email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @Builder
    public Account (String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void addBoard(Board board) {
        boards.add(board);
        board.setAccount(this);
    }
}
