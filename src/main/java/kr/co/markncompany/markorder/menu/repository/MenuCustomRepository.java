package kr.co.markncompany.markorder.menu.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.markncompany.markorder.menu.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static kr.co.markncompany.markorder.menu.QMenu.menu;
import static kr.co.markncompany.markorder.menu.QMenuOption.menuOption;
import static kr.co.markncompany.markorder.menu.QOptionGroup.optionGroup;
import static kr.co.markncompany.markorder.menu.QOptions.options;

@Repository
@RequiredArgsConstructor
public class MenuCustomRepository {

    private final JPAQueryFactory queryFactory;

    /**
     * 전체 메뉴 조회
     * @return
     */
    public List<MenuDto> getMenuList() {
        return queryFactory
                .select(Projections.constructor(MenuDto.class,
                        menu
                ))
                .from(menu)
                .fetch();
    }

    /**
     * 메뉴 상세 조회
     * @param id
     * @return
     */
    public List<MenuDto> getMenuInfoByMenuId(String id) {
        return queryFactory
                .select(Projections.constructor(MenuDto.class,
                        menu,
                        menuOption,
                        options,
                        optionGroup
                ))
                .from(menu)
                .leftJoin(menuOption).on(menu.id.eq(menuOption.menu.id))
                .leftJoin(options).on(menuOption.options.id.eq(options.id))
                .leftJoin(optionGroup).on(options.optionGroup.id.eq(optionGroup.id))
                .where(
                        menu.id.eq(id)
                )
                .fetch();
    }

}
