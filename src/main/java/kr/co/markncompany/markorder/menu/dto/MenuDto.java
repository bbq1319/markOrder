package kr.co.markncompany.markorder.menu.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.menu.Menu;
import kr.co.markncompany.markorder.menu.MenuOption;
import kr.co.markncompany.markorder.menu.OptionGroup;
import kr.co.markncompany.markorder.menu.Options;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class MenuDto {

    private String id;
    private String menuName;
    private String menuType;
    private Long menuPrice;
    private Long stock;

    // 전체 메뉴 조회
    // 메뉴 상세 조회
    @QueryProjection
    public MenuDto(Menu menu) {
        setByMenu(menu);
    }

    private void setByMenu(Menu menu) {
        this.id = menu.getId();
        this.menuName = menu.getMenuName();
        this.menuType = menu.getMenuType();
        this.menuPrice = menu.getMenuPrice();
        this.stock = menu.getStock();
    }

}
