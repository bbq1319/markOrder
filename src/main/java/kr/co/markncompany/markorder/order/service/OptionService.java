package kr.co.markncompany.markorder.order.service;

import kr.co.markncompany.markorder.order.OptionGroup;
import kr.co.markncompany.markorder.order.dto.OptionGroupDto;
import kr.co.markncompany.markorder.order.repository.OptionGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OptionService {

    private final OptionGroupRepository optionGroupRepository;

    @Transactional
    public long insertOptionGroup(OptionGroupDto optionGroupDto) {
        OptionGroup optionGroup = new OptionGroup(optionGroupDto);
        OptionGroup save = optionGroupRepository.save(optionGroup);
        return save.getId();
    }

}
