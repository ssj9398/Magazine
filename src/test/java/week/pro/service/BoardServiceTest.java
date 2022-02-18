package week.pro.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import week.pro.domain.Account;
import week.pro.domain.Board;
import week.pro.dto.AccountRequestDto;
import week.pro.dto.BoardRequestDto;
import week.pro.repository.AccountRepository;
import week.pro.repository.BoardRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EntityManager em;

    @Test
    public void 게시글등록() throws Exception {
        //given
        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
        accountService.addUser(accountRequestDto);
        em.flush();

        //when
        BoardRequestDto boardRequestDto = new BoardRequestDto("abcd@google.com","내용내용");
        Long findBoardId = boardService.addBoard(boardRequestDto);
        System.out.println("findBoardId"  + findBoardId);
        Optional<Board> findId = boardRepository.findById(findBoardId);
        System.out.println("findId" +findId);
        em.flush();

        //then
        Assertions.assertThat(findBoardId).isEqualTo(findId.get().getId());

    }

    @Test
    public void 게시글전체조회() throws Exception {
        //given
        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
        accountService.addUser(accountRequestDto);
        em.flush();

        //when
        BoardRequestDto boardRequestDto = new BoardRequestDto("abcd@google.com","내용내용");
        Long findBoardId = boardService.addBoard(boardRequestDto);
        BoardRequestDto boardRequestDto2 = new BoardRequestDto("abcd@google.com","내용내용2");
        Long findBoardId2 = boardService.addBoard(boardRequestDto2);
        BoardRequestDto boardRequestDto3 = new BoardRequestDto("abcd@google.com","내용내용3");
        Long findBoardId3 = boardService.addBoard(boardRequestDto3);

        em.flush();

        //then
        List<Board> boardList = boardService.findBoard();
        System.out.println(boardList);
        Assertions.assertThat(boardList.size()).isEqualTo(3);
    }

}