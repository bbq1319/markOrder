package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(name = "option_group_id")
    private String id;
    private String groupName;
    private boolean required;
    private int minSelect;
    private int maxSelect;

    @OneToMany
    @JoinColumn(name = "option_group_id")
    @JsonManagedReference
    private List<Options> options = new ArrayList<>();

    @OneToMany(mappedBy = "optionGroup")
    @JsonBackReference
    private List<MenuOptionGroup> menuOptionGroups = new ArrayList<>();

    public OptionGroup(OptionGroupDto optionGroupDto) {
        groupName = optionGroupDto.getGroupName();
        required = optionGroupDto.isRequired();
        minSelect = optionGroupDto.getMinSelect();
        maxSelect = optionGroupDto.getMaxSelect();
    }

}
