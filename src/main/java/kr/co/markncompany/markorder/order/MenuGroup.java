package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.order.dto.MenuGroupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class MenuGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;

    @OneToMany
    @JoinColumn(name = "menu_group_id")
    private List<Menu> menus = new ArrayList<>();

    public MenuGroup(MenuGroupDto menuGroupDto) {
        this.groupName = menuGroupDto.getGroupName();
    }

}
