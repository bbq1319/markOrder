package kr.co.markncompany.markorder.order.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.order.Menu;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto {

    private long id;
    private String name;
    private String engName;
    private String price;
    private long menuGroupId;

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
