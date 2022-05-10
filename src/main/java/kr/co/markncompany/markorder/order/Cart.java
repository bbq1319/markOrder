package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.menu.Menu;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Cart extends BaseEntity {

    @Id
    @Column(name = "cart_id")
    private String id;
    private Long price;
    private Long quantity;
    private String cartType;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    // User

    @Builder.Default
    @OneToMany(mappedBy = "cart")
    private List<CartOption> cartOptions = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "cart")
    private List<OrderCart> orderCarts = new ArrayList<>();

}
