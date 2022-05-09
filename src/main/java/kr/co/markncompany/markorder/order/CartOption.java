package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.menu.Options;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CartOption extends BaseEntity {

    @Id
    @Column(name = "cart_option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Options options;

}
