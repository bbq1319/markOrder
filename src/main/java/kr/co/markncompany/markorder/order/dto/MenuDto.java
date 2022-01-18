package kr.co.markncompany.markorder.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuDto {

    private long id;
    private String name;
    private String engName;
    private String price;

}
