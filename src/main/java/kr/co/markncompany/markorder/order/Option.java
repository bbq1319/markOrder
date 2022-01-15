package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Option {

    @Id
    private String id;
    private String price;
    private String name;

}
