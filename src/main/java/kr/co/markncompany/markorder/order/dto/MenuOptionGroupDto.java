package kr.co.markncompany.markorder.order.dto;

import lombok.Data;

@Data
public class MenuOptionGroupDto {

    private long id;
    private Long orderPrice;
    private int count;
    private long menuId;
    private long optionGroupId;

}
