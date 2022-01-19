package kr.co.markncompany.markorder.order.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.markncompany.markorder.order.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.co.markncompany.markorder.order.QMenu.menu;

@Repository
@RequiredArgsConstructor
public class MenuCustomRepository {

    private final JPAQueryFactory queryFactory;

    public List<MenuDto> getMenuList() {
        return queryFactory
                .select(Projections.constructor(MenuDto.class,
                        menu
                ))
                .from(menu)
                .fetch();
    }

}
