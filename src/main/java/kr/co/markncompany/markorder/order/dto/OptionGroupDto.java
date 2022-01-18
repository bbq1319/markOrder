package kr.co.markncompany.markorder.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OptionGroupDto {

    private long id;
    private String groupName;
    private boolean required;
    private int minSelect;
    private int maxSelect;

}
