package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.order.dto.MenuOptionGroupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class MenuOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long orderPrice;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private OptionGroup optionGroup;

    public MenuOptionGroup(MenuOptionGroupDto menuOptionGroupDto, Menu menu, OptionGroup optionGroup) {
        this.orderPrice = menuOptionGroupDto.getOrderPrice();
        this.menu = menu;
        this.optionGroup = optionGroup;
    }

}
