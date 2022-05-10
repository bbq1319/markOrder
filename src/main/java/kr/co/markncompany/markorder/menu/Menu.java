package kr.co.markncompany.markorder.menu;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.menu.dto.MenuDto;
import kr.co.markncompany.markorder.order.Cart;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Menu extends BaseEntity {

    @Id
    @Column(name = "menu_id")
    private String id;
    private String menuName;
    private String menuType;
    private Long menuPrice;
    private Long stock;

    @Builder.Default
    @OneToMany(mappedBy = "menu")
    private List<MenuOption> menuOptions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "menu")
    private List<Cart> carts = new ArrayList<>();

    public Menu(MenuDto menuDto) {
        this.id = menuDto.getId();
        this.menuName = menuDto.getMenuName();
        this.menuType = menuDto.getMenuType();
        this.menuPrice = menuDto.getMenuPrice();
        this.stock = menuDto.getStock();
    }

}
