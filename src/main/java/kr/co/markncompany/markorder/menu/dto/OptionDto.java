package kr.co.markncompany.markorder.menu.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.menu.MenuOption;
import kr.co.markncompany.markorder.menu.OptionGroup;
import kr.co.markncompany.markorder.menu.Options;
import lombok.Data;

@Data
public class OptionDto {

    private String id;
    private String optionName;
    private Long optionPrice;
    private Long stock;
    private boolean defaultCheck;

    // MenuOption
    private Long menuOptionPrice;
    private boolean required;

    // OptionGroup
    private String optionGroupName;
    private String optionType;

    private MenuOptionDto menuOptionDto;

    public OptionDto(MenuOption menuOption, Options options) {
        setByOptions(options);
        this.menuOptionDto = new MenuOptionDto(menuOption);
    }

    private void setByOptions(Options options) {
        this.id = options.getId();
        this.optionName = options.getOptionName();
        this.optionPrice = options.getOptionPrice();
        this.stock = options.getStock();
        this.defaultCheck = options.isDefaultCheck();
    }

    private void setByMenuOption(MenuOption menuOption) {
        this.menuOptionPrice = menuOption.getPrice();
        this.required = menuOption.isRequired();
    }

    private void setByOptionGroup(OptionGroup optionGroup) {
        this.optionGroupName = optionGroup.getOptionGroupName();
        this.optionType = optionGroup.getOptionType();
    }

}
