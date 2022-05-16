package kr.co.markncompany.markorder.menu.dto;

import com.querydsl.core.annotations.QueryProjection;
import kr.co.markncompany.markorder.menu.MenuOption;
import kr.co.markncompany.markorder.menu.OptionGroup;
import kr.co.markncompany.markorder.menu.Options;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OptionGroupDto {

    private String id;
    private String optionGroupName;
    private String optionType;

    // Options
    private String optionName;
    private Long optionPrice;
    private Long stock;
    private boolean defaultCheck;

    // MenuOption
    private Long menuOptionPrice;
    private boolean required;

    @QueryProjection
    public OptionGroupDto(Options options, MenuOption menuOption, OptionGroup optionGroup) {
        setByOptions(options);
        setByMenuOption(menuOption);
        setByOptionGroup(optionGroup);
    }

    private void setByOptions(Options options) {
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
        this.id = optionGroup.getId();
        this.optionGroupName = optionGroup.getOptionGroupName();
        this.optionType = optionGroup.getOptionType();
    }

}
