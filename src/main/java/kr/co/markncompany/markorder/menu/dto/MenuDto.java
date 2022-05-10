package kr.co.markncompany.markorder.menu.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.menu.Menu;
import kr.co.markncompany.markorder.menu.MenuOption;
import kr.co.markncompany.markorder.menu.OptionGroup;
import kr.co.markncompany.markorder.menu.Options;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

    private String id;
    private String menuName;
    private String menuType;
    private Long menuPrice;
    private Long stock;

    private MenuOption menuOption;
    private Options options;
    private OptionGroup optionGroup;

    // 전체 메뉴 조회
    @QueryProjection
    public MenuDto(Menu menu) {
        setByMenu(menu);
    }

    // 메뉴 상세 조회
    @QueryProjection
    public MenuDto(Menu menu, MenuOption menuOption, Options options, OptionGroup optionGroup) {
        setByMenu(menu);
        this.menuOption = menuOption;
        this.options = options;
        this.optionGroup = optionGroup;
    }

    private void setByMenu(Menu menu) {
        this.id = menu.getId();
        this.menuName = menu.getMenuName();
        this.menuType = menu.getMenuType();
        this.menuPrice = menu.getMenuPrice();
        this.stock = menu.getStock();
    }

}
