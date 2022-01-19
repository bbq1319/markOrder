package kr.co.markncompany.markorder.order.dto;

import lombok.Data;

@Data
public class OptionDto {

    private long id;
    private String price;
    private String name;
    private long optionGroupId;

}
