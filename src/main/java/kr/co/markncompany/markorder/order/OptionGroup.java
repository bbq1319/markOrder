package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class OptionGroup {

    @Id
    private String id;
    private String grpName;
    private boolean required;
    private int minSelect;

}
