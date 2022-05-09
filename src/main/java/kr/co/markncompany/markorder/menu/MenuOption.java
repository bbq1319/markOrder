package kr.co.markncompany.markorder.menu;

import kr.co.markncompany.markorder.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MenuOption extends BaseEntity {

    @Id
    @Column(name = "menu_option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Options options;

    private Long price;
    private boolean required;

}
