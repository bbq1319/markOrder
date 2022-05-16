package kr.co.markncompany.markorder.menu.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.markncompany.markorder.menu.dto.MenuDto;
import kr.co.markncompany.markorder.menu.dto.OptionDto;
import kr.co.markncompany.markorder.menu.dto.OptionGroupDto;
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
    public MenuDto getMenuInfoByMenuId(String id) {
        return queryFactory
                .select(Projections.constructor(MenuDto.class,
                        menu
                ))
                .from(menu)
                .where(
                        menu.id.eq(id)
                )
                .fetchOne();
    }

    public List<OptionGroupDto> getOptionInfoByMenuId(String menuId) {
        return queryFactory
                .select(Projections.constructor(OptionGroupDto.class,
                        options,
                        menuOption,
                        optionGroup
                ))
                .from(menuOption)
                .leftJoin(options).on(menuOption.options.id.eq(options.id))
                .leftJoin(optionGroup).on(options.optionGroup.id.eq(optionGroup.id))
                .where(menuOption.menu.id.eq(menuId))
                .fetch();
    }

}
