package kr.co.markncompany.markorder.order.service;

import kr.co.markncompany.markorder.order.OptionGroup;
import kr.co.markncompany.markorder.order.Options;
import kr.co.markncompany.markorder.order.dto.OptionDto;
import kr.co.markncompany.markorder.order.dto.OptionGroupDto;
import kr.co.markncompany.markorder.order.repository.OptionGroupRepository;
import kr.co.markncompany.markorder.order.repository.OptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;
    private final OptionGroupRepository optionGroupRepository;

    @Transactional
    public long insertOption(OptionDto optionDto) {
        OptionGroup optionGroup = optionGroupRepository.findById(optionDto.getOptionGroupId()).orElseThrow(() -> new IllegalArgumentException("옵션그룹을 찾을 수 없습니다.."));
        Options options = new Options(optionDto, optionGroup);
        Options save = optionRepository.save(options);
        return save.getId();
    }

    @Transactional
    public long insertOptionGroup(OptionGroupDto optionGroupDto) {
        OptionGroup optionGroup = new OptionGroup(optionGroupDto);
        OptionGroup save = optionGroupRepository.save(optionGroup);
        return save.getId();
    }

}
