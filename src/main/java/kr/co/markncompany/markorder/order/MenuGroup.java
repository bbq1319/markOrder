package kr.co.markncompany.markorder.order;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class MenuGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;

    @OneToMany
    @JoinColumn(name = "menu_group_id")
    private List<Menu> menus = new ArrayList<>();

}
