package kr.co.markncompany.markorder.order.service;

import kr.co.markncompany.markorder.order.dto.MenuDto;
import kr.co.markncompany.markorder.order.repository.MenuCustomRepository;
import kr.co.markncompany.markorder.order.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private MenuRepository menuRepository;
    private MenuCustomRepository menuCustomRepository;

    @Transactional
    public long insertMenu(MenuDto menuDto) {
        return 1;
    }

}
