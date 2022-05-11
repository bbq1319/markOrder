package kr.co.markncompany.markorder.menu.dto;

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

    private OptionDto optionDto;
    private List<OptionDto> optionDtoList = new ArrayList<>();

    public OptionGroupDto(List<OptionGroupDto> optionGroupDtoList) {
        for (int i = 0; i < optionGroupDtoList.size(); i++) {
            OptionGroupDto dto = optionGroupDtoList.get(i);
            if (i == 0) {
                id = dto.id;
                optionGroupName = dto.optionGroupName;
                optionType = dto.optionType;
            }
            this.optionDtoList.add(dto.getOptionDto());
        }
    }

    public OptionGroupDto(MenuOption menuOption, Options options, OptionGroup optionGroup) {
        setByOptionGroup(optionGroup);
        this.optionDto = new OptionDto(menuOption, options);
    }

    private void setByOptionGroup(OptionGroup optionGroup) {
        this.id = optionGroup.getId();
        this.optionGroupName = optionGroup.getOptionGroupName();
        this.optionType = optionGroup.getOptionType();
    }

}
