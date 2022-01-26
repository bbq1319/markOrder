package kr.co.markncompany.markorder.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kr.co.markncompany.markorder.order.dto.OptionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Options {

    @Id
    @Column(name = "option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String price;
    private String name;

    @ManyToOne
    @JoinColumn(name = "option_group_id", updatable = false)
    @JsonBackReference
    private OptionGroup optionGroup;

    public Options(OptionDto optionDto, OptionGroup optionGroup) {
        this.price = optionDto.getPrice();
        this.name = optionDto.getName();
        this.optionGroup = optionGroup;
    }

}
