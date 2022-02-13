package kr.co.markncompany.markorder.order.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.markncompany.markorder.order.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.co.markncompany.markorder.order.QMenu.menu;
import static kr.co.markncompany.markorder.order.QMenuOptionGroup.menuOptionGroup;

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

    public MenuDto getMenuInfoByMenuId(String id) {
        return queryFactory
                .select(Projections.constructor(MenuDto.class,
                        menu
                ))
                .from(menu)
                .leftJoin(menuOptionGroup).on(menu.id.eq(menuOptionGroup.menu.id))
                .where(menu.id.eq(id))
                .fetchOne();
    }

}
