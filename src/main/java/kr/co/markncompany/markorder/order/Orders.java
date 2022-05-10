package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Orders extends BaseEntity {

    @Id
    @Column(name = "order_id")
    private String id;
    private Long price;
    private String orderType;

    @Builder.Default
    @OneToMany(mappedBy = "orders")
    private List<OrderCart> orderCarts = new ArrayList<>();

}
