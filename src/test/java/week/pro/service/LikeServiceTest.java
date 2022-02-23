//package week.pro.service;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import week.pro.domain.Board;
//import week.pro.domain.Likes;
//import week.pro.dto.AccountRequestDto;
//import week.pro.dto.BoardRequestDto;
//import week.pro.repository.board.BoardRepository;
//import week.pro.repository.LikeRepository;
//
//import javax.persistence.EntityManager;
//import java.util.Optional;
//
//@SpringBootTest
//@Transactional
//class LikeServiceTest {
//
//    @Autowired
//    private EntityManager em;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private BoardService boardService;
//
//    @Autowired
//    private BoardRepository boardRepository;
//
//    @Autowired
//    private LikeRepository likeRepository;
//
//    @Autowired
//    private LikeService likeService;
//
//
//    @Test
//    public void 게시글좋아요등록() throws Exception {
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        accountService.addUser(accountRequestDto);
//
//        BoardRequestDto boardRequestDto = new BoardRequestDto("abcd@google.com", "내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//        Optional<Board> findId = boardRepository.findById(findBoardId);
//
//        //when
//        Board board = likeService.addLike(findBoardId);
//        Optional<Likes> likeFind = likeRepository.findById(findId.get().getId());
//        em.flush();
//        //then
//        Assertions.assertThat(board.getLikes().size()).isEqualTo(1);
//    }
//
//    @Test
//    public void 게시글좋아요삭제() throws Exception {
//        //given
//        AccountRequestDto accountRequestDto = new AccountRequestDto("홍길동님", "abcd@google.com", "1234");
//        Long findUser = accountService.addUser(accountRequestDto);
//
//        BoardRequestDto boardRequestDto = new BoardRequestDto("abcd@google.com", "내용내용");
//        Long findBoardId = boardService.addBoard(boardRequestDto);
//        Optional<Board> findId = boardRepository.findById(findBoardId);
//
//        //when
//        likeRepository.deleteLike(findId.get().getId(), findUser);
//        Optional<Likes> deletefindId = likeRepository.findById(findId.get().getId());
//
//        //then
//        Assertions.assertThat(deletefindId).isEmpty();
//
//    }
//}