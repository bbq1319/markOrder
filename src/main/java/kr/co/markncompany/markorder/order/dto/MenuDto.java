package kr.co.markncompany.markorder.order.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.order.Menu;
import kr.co.markncompany.markorder.order.MenuOptionGroup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuDto {

    private String id;
    private String name;
    private String engName;
    private String price;
    private String menuGroupId;

    private List<MenuOptionGroup> menuOptionGroupList;

    // 메뉴 조회
    @QueryProjection
    public MenuDto(Menu menu) {
        this.id = menu.getId();
        this.name = menu.getName();
        this.engName = menu.getEngName();
        this.price = menu.getPrice();
        this.menuGroupId = menu.getMenuGroup().getId();
    }

}
