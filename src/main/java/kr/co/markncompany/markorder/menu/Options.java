package kr.co.markncompany.markorder.menu;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.order.CartOption;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Options extends BaseEntity {

    @Id
    @Column(name = "option_id")
    private String id;
    private String optionName;
    private Long optionPrice;
    private Long stock;
    private boolean defaultCheck;

    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private OptionGroup optionGroup;

    @Builder.Default
    @OneToMany(mappedBy = "options")
    private List<MenuOption> menuOptions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "options")
    private List<CartOption> cartOptions = new ArrayList<>();

}
