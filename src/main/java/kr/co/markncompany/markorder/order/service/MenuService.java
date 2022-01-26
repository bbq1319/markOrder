package kr.co.markncompany.markorder.order.service;

import kr.co.markncompany.markorder.order.Menu;
import kr.co.markncompany.markorder.order.MenuGroup;
import kr.co.markncompany.markorder.order.MenuOptionGroup;
import kr.co.markncompany.markorder.order.OptionGroup;
import kr.co.markncompany.markorder.order.dto.MenuDto;
import kr.co.markncompany.markorder.order.dto.MenuGroupDto;
import kr.co.markncompany.markorder.order.dto.MenuOptionGroupDto;
import kr.co.markncompany.markorder.order.repository.MenuGroupRepository;
import kr.co.markncompany.markorder.order.repository.MenuOptionGroupRepository;
import kr.co.markncompany.markorder.order.repository.MenuRepository;
import kr.co.markncompany.markorder.order.repository.OptionGroupRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuGroupRepository menuGroupRepository;
    private final MenuOptionGroupRepository menuOptionGroupRepository;
    private final OptionGroupRepository optionGroupRepository;

    @Transactional
    public long insertMenu(MenuDto menuDto) {
        MenuGroup menuGroup = menuGroupRepository.findById(menuDto.getMenuGroupId())
                .orElseThrow(() -> new IllegalArgumentException("메뉴그룹을 찾을 수 없습니다.."));
        Menu menu = new Menu(menuDto, menuGroup);
        Menu save = menuRepository.save(menu);
        return save.getId();
    }

    @Transactional
    public long insertMenuGroup(MenuGroupDto menuGroupDto) {
        MenuGroup menuGroup = new MenuGroup(menuGroupDto);
        MenuGroup save = menuGroupRepository.save(menuGroup);
        return save.getId();
    }

    @Transactional
    public long insertMenuOptionGroup(MenuOptionGroupDto menuOptionGroupDto) {
        Menu menu = menuRepository.findById(menuOptionGroupDto.getMenuId())
                .orElseThrow(() -> new IllegalArgumentException("메뉴를 찾을 수 없습니다.."));
        OptionGroup optionGroup = optionGroupRepository.findById(menuOptionGroupDto.getOptionGroupId())
                .orElseThrow(() -> new IllegalArgumentException("메뉴그룹을 찾을 수 없습니다.."));
        MenuOptionGroup menuOptionGroup = new MenuOptionGroup(menu, optionGroup);
        MenuOptionGroup save = menuOptionGroupRepository.save(menuOptionGroup);
        return 1;
    }

}
