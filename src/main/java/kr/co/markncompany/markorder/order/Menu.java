package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String engName;
    private String price;

    @ManyToOne
    @JoinColumn(name = "menu_group_id", insertable = false, updatable = false)
    private MenuGroup menuGroup;

    @OneToMany(mappedBy = "menu")
    private List<MenuOptionGroup> menuOptionGroups = new ArrayList<>();

}
