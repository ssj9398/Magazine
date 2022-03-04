package week.pro.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.dto.request.BoardRequestDto;
import week.pro.dto.request.LoginRequestDto;
import week.pro.dto.request.RegisterRequestDto;
import week.pro.dto.response.LoginResponseDto;
import week.pro.repository.AccountRepository;
import week.pro.repository.board.BoardRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("account")
@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    BoardService boardService;

    @Test
    void addBoard() {
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

        //when
        Long findBoard = boardService.addBoard(account, boardRequestDto);
        Optional<Board> byId = boardRepository.findById(findBoard);

        //then
        Assertions.assertThat(findBoard).isEqualTo(1);
        Assertions.assertThat(byId.get().getBoard_status()).isEqualTo("bottom");
        Assertions.assertThat(byId.get().getImg_url()).isEqualTo("http://naver.com");
        Assertions.assertThat(byId.get().getContents()).isEqualTo("내용내용");

    }

    @Test
    void findAllBoard() {
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

        BoardRequestDto boardRequestDto2 = BoardRequestDto.builder()
                .board_status("top")
                .content("내용내용")
                .img_url("http://naver.com")
                .build();

        BoardRequestDto boardRequestDto3 = BoardRequestDto.builder()
                .board_status("bottom")
                .content("내용내용")
                .img_url("http://naver.com")
                .build();

        //when
        boardService.addBoard(account, boardRequestDto);
        boardService.addBoard(account, boardRequestDto2);
        boardService.addBoard(account, boardRequestDto3);
        List<Board> all = boardRepository.findAll();

        //then
        Assertions.assertThat(all.size()).isEqualTo(3);
    }

    @Test
    void modifyBoard() {
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
        BoardRequestDto modify = BoardRequestDto.builder()
                .board_status("left")
                .img_url("https://google.com")
                .content("용내용내")
                .build();

        Optional<Board> boardId = boardService.modifyBoard(byId.get().getId(), modify, account.getId());

        //then
        Assertions.assertThat(findBoard).isEqualTo(boardId.get().getId());
    }

    @Test
    void removeBoard() {
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

        Long findBoard = boardService.addBoard(account, boardRequestDto);
        Optional<Board> byId = boardRepository.findById(findBoard);

        //when
        boardRepository.deleteById(byId.get().getId());
        List<Board> all = boardRepository.findAll();

        //then
        Assertions.assertThat(all).isEmpty();


    }

}