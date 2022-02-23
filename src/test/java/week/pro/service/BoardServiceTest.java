//package week.pro.service;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import week.pro.domain.Account;
//import week.pro.domain.Board;
//import week.pro.dto.AccountRequestDto;
//import week.pro.dto.BoardRequestDto;
//import week.pro.repository.AccountRepository;
//import week.pro.repository.board.BoardRepository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class BoardServiceTest {
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private EntityManager em;
//
//    @Test
//    public void 게시글등록() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//        em.flush();
//
//        //when
//        BoardRequestDto boardRequestDto = new BoardRequestDto(1L,"내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//        System.out.println("findBoardId"  + findBoardId);
//        Optional<Board> findId = boardRepository.findById(findBoardId);
//        System.out.println("findId" +findId);
//        em.flush();
//
//        //then
//        assertThat(findBoardId).isEqualTo(findId.get().getId());
//
//    }
//
//    @Test
//    public void 게시글전체조회() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//
//        //when
//        BoardRequestDto boardRequestDto = new BoardRequestDto(1L,"내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//        BoardRequestDto boardRequestDto2 = new BoardRequestDto(1L,"내용내용2");
//        Long findBoardId2 = boardService.addBoard(boardRequestDto2);
//        BoardRequestDto boardRequestDto3 = new BoardRequestDto(1L,"내용내용3");
//        Long findBoardId3 = boardService.addBoard(boardRequestDto3);
//
//        em.flush();
//
//        //then
//        List<Board> boardList = boardService.findBoard();
//        System.out.println(boardList);
//        assertThat(boardList.size()).isEqualTo(3);
//    }
//
//    @Test
//    public void 게시글상세조회() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//
//        BoardRequestDto boardRequestDto = new BoardRequestDto(1L, "내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//
//        BoardRequestDto boardRequestDto2 = new BoardRequestDto(1L, "내용내용2");
//        Long findBoardId2 = boardService.addBoard(boardRequestDto2);
//
//        BoardRequestDto boardRequestDto3 = new BoardRequestDto(1L, "내용내용3");
//        Long findBoardId3 = boardService.addBoard(boardRequestDto3);
//
//        em.flush();
//        //when
//        Optional<Board> BoardOne1 = boardRepository.findById(findBoardId);
//        Optional<Board> BoardOne2 = boardRepository.findById(findBoardId2);
//        Optional<Board> BoardOne3 = boardRepository.findById(findBoardId3);
//
//        //then
//        assertThat(findBoardId).isEqualTo(BoardOne1.get().getId());
//        assertThat(findBoardId2).isEqualTo(BoardOne2.get().getId());
//        assertThat(findBoardId3).isEqualTo(BoardOne3.get().getId());
//    }
//
//    @Test
//    public void 게시글수정() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//
//        BoardRequestDto boardRequestDto = new BoardRequestDto(1L,"내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//        Optional<Board> findId = boardRepository.findById(findBoardId);
//        em.flush();
//        //when
//
//        Board.BoardModify boardModify = new Board.BoardModify();
//        Optional<Board> board = boardService.modifyBoard(findBoardId, boardModify);
//
//        //then
//        assertThat(board.get().getContent()).isEqualTo("수정수정");
//    }
//    @Test
//    public void 게시글삭제() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//
//        BoardRequestDto boardRequestDto = new BoardRequestDto(1L,"내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//
//
//        //when
//        Optional<Board> findId = boardRepository.findById(findBoardId);
//        boardRepository.deleteById(findId.get().getId());
//
////        List<Board> allBoard = boardRepository.findAll();
//        Optional<Board> findDeleteId = boardRepository.findById(findId.get().getId());
//
//        //then
//        em.flush();
//        Assertions.assertThat(findDeleteId.isPresent());
//    }
//}