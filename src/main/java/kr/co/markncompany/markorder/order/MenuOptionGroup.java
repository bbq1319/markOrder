package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(MenuOptionGroupId.class)
public class MenuOptionGroup implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonBackReference
    private Menu menu;

    @Id
    @ManyToOne
    @JoinColumn(name = "option_group_id")
    @JsonManagedReference
    private OptionGroup optionGroup;

    public MenuOptionGroup(Menu menu, OptionGroup optionGroup) {
        this.menu = menu;
        this.optionGroup = optionGroup;
    }

}
