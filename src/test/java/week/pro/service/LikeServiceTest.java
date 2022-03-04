package week.pro.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.domain.Likes;
import week.pro.dto.request.BoardRequestDto;
import week.pro.dto.request.LoginRequestDto;
import week.pro.dto.request.RegisterRequestDto;
import week.pro.repository.AccountRepository;
import week.pro.repository.LikeRepository;
import week.pro.repository.board.BoardRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("account")
@SpringBootTest
@Transactional
class LikeServiceTest {
    @Autowired
    AccountService accountService;

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    LikeService likeService;

    @Autowired
    LikeRepository likeRepository;

    @Test
    void addLike() {
        //given
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .account_email("test@google.com")
                .account_name("abcde")
                .password("123456")
                .password_check("123456")
                .build();

        Account account = null;
        accountService.addUser(registerRequestDto, account);

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .account_email("test@google.com")
                .password("123456")
                .build();

        accountService.loginUser(loginRequestDto, account);
        BoardRequestDto boardRequestDto = BoardRequestDto.builder()
                .board_status("bottom")
                .content("내용내용")
                .img_url("http://naver.com")
                .build();

        account = Account.builder()
                .email("test@google.com")
                .password("123456")
                .name("abcde")
                .build();
        accountRepository.save(account);

        Long findBoard = boardService.addBoard(account, boardRequestDto);

        //when
        Optional<Board> byId = boardRepository.findById(findBoard);
        likeService.addLike(findBoard,byId.get().getAccount().getId());

        //then
        List<Likes> likeCount = likeRepository.findAll();
        Assertions.assertThat(likeCount.size()).isEqualTo(1);
    }

    @Test
    void removeLike() {

        //given
        RegisterRequestDto registerRequestDto = RegisterRequestDto.builder()
                .account_email("test@google.com")
                .account_name("abcde")
                .password("123456")
                .password_check("123456")
                .build();

        Account account = null;
        accountService.addUser(registerRequestDto, account);

        LoginRequestDto loginRequestDto = LoginRequestDto.builder()
                .account_email("test@google.com")
                .password("123456")
                .build();

        accountService.loginUser(loginRequestDto, account);
        BoardRequestDto boardRequestDto = BoardRequestDto.builder()
                .board_status("bottom")
                .content("내용내용")
                .img_url("http://naver.com")
                .build();

        account = Account.builder()
                .email("test@google.com")
                .password("123456")
                .name("abcde")
                .build();
        accountRepository.save(account);

        Long findBoard = boardService.addBoard(account, boardRequestDto);

        Optional<Board> byId = boardRepository.findById(findBoard);
        likeService.addLike(findBoard,byId.get().getAccount().getId());

        //when
        likeService.removeLike(byId.get().getId(), byId.get().getAccount().getId());


        //then
        List<Likes> likeCount = likeRepository.findAll();
        Assertions.assertThat(likeCount).isEmpty();
    }
}