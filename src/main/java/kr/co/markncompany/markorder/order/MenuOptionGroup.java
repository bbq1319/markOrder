package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class MenuOptionGroup {

    @Id
    private String menuId;
    @Id
    private String optionGroupId;

}
