package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String price;
    private String name;

    @ManyToOne
    @JoinColumn(name = "option_group_id", insertable = false, updatable = false)
    private OptionGroup optionGroup;

}
