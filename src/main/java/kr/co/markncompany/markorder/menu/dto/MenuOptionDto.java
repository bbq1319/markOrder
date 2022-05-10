package kr.co.markncompany.markorder.menu.dto;

import kr.co.markncompany.markorder.menu.MenuOption;
import lombok.Data;

@Data
public class MenuOptionDto {

    private Long id;
    private String menuId;
    private String optionsId;
    private Long price;
    private boolean required;

    public MenuOptionDto(MenuOption menuOption) {
        setByMenuOption(menuOption);
    }

    private void setByMenuOption(MenuOption menuOption) {
        this.id = menuOption.getId();
        this.menuId = menuOption.getMenu().getId();
        this.optionsId = menuOption.getOptions().getId();
        this.price = menuOption.getPrice();
        this.required = menuOption.isRequired();
    }

}
