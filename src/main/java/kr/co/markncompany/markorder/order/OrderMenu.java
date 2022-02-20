package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kr.co.markncompany.markorder.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@IdClass(OrderMenuId.class)
public class OrderMenu extends BaseEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "order")
    @JsonBackReference
    private Orders order;

    @Id
    @ManyToOne
    @JoinColumn(name = "menu")
    @JsonBackReference
    private Menu menu;

    private OrderMenu(Orders order, Menu menu) {
        this.order = order;
        this.menu = menu;
    }

}
