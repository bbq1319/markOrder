package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Orders extends BaseEntity {

    @Id
    @Column(name = "order_id")
    private String id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderMenu> orderMenu = new ArrayList<>();


}
