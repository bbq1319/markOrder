package kr.co.markncompany.markorder.menu;

import com.querydsl.core.annotations.QueryProjection;
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
public class OptionGroup extends BaseEntity {

    @Id
    @Column(name = "option_group_id")
    private String id;
    private String optionGroupName;
    private String optionType;

    @Builder.Default
    @OneToMany(mappedBy = "optionGroup")
    private List<Options> options = new ArrayList<>();

}
