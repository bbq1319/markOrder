package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.order.dto.OptionGroupDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class OptionGroup extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;
    private boolean required;
    private int minSelect;
    private int maxSelect;

    @OneToMany
    @JoinColumn(name = "option_group_id")
    private List<Options> options = new ArrayList<>();

    @OneToMany(mappedBy = "optionGroup")
    private List<MenuOptionGroup> menuOptionGroups = new ArrayList<>();

    public OptionGroup(OptionGroupDto optionGroupDto) {
        groupName = optionGroupDto.getGroupName();
        required = optionGroupDto.isRequired();
        minSelect = optionGroupDto.getMinSelect();
        maxSelect = optionGroupDto.getMaxSelect();
    }

}
