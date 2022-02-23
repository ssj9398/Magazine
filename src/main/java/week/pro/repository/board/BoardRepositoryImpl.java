package week.pro.repository.board;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import week.pro.domain.Board;
import week.pro.domain.QAccount;
import week.pro.domain.QBoard;
import week.pro.dto.BoardPageResponseDto;
import week.pro.dto.BoardResponseDto;
import week.pro.dto.QBoardPageResponseDto;

import javax.persistence.EntityManager;
import java.util.List;

//@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(EntityManager em){
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }
    @Override
    public List<Board> findAllBoard() {
        return jpaQueryFactory
                .select(QBoard.board)
                .from(QBoard.board)
                .leftJoin(QBoard.board.account,QAccount.account)
                .fetch();
    }

    @Override
    public Page<BoardPageResponseDto> findAllBoardPage(Pageable pageable) {
        QueryResults<BoardPageResponseDto> results = jpaQueryFactory
                .select(new QBoardPageResponseDto(
                        QBoard.board
                ))
                .from(QBoard.board)
                .leftJoin(QBoard.board.account,QAccount.account)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<BoardPageResponseDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
