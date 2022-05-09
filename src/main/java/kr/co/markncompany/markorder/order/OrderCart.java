package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.common.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OrderCart extends BaseEntity {

    @Id
    @Column(name = "order_cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Long price;

}