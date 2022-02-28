package week.pro.repository.board;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import week.pro.domain.QAccount;
import week.pro.dto.response.BoardPageResponseDto;
import week.pro.dto.response.QBoardPageResponseDto;

import java.util.List;

import static week.pro.domain.QBoard.board;

public class BoardRepositoryImpl implements BoardRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<BoardPageResponseDto> findAllBoardPage(Pageable pageable) {
        QueryResults<BoardPageResponseDto> results = jpaQueryFactory
                .select(new QBoardPageResponseDto(
                        board
                ))
                .from(board)
                .leftJoin(board.account,QAccount.account)

                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(board.modifiedAt.desc())
                .fetchResults();
        List<BoardPageResponseDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }
}
