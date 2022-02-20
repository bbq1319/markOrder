package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.order.dto.MenuDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Menu extends BaseEntity {

    @Id
    @Column(name = "menu_id")
    private String id;
    private String name;
    private String engName;
    private String price;

    @ManyToOne
    @JoinColumn(name = "menu_group_id", updatable = false)
    @JsonManagedReference
    private MenuGroup menuGroup;

    @OneToMany(mappedBy = "menu")
    private List<MenuOptionGroup> menuOptionGroups = new ArrayList<>();

    public Menu(MenuDto menuDto, MenuGroup menuGroup) {
        this.name = menuDto.getName();
        this.engName = menuDto.getEngName();
        this.price = menuDto.getPrice();
        this.menuGroup = menuGroup;
    }

}
