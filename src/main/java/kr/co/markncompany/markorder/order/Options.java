package kr.co.markncompany.markorder.order;

import kr.co.markncompany.markorder.order.dto.OptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String price;
    private String name;

    @ManyToOne
    @JoinColumn(name = "option_group_id", updatable = false)
    private OptionGroup optionGroup;

    public Options(OptionDto optionDto, OptionGroup optionGroup) {
        this.price = optionDto.getPrice();
        this.name = optionDto.getName();
        this.optionGroup = optionGroup;
    }

}
