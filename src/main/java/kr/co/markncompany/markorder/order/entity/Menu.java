package kr.co.markncompany.markorder.order.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
public class Menu {

    @Id
    private long id;
    private String name;
    private String price;

}
