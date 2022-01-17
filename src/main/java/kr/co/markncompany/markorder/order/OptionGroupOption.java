package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class OptionGroupOption {

    @Id
    private String OptionGroupId;
    @Id
    private String OptionId;
    private String priority;

}
