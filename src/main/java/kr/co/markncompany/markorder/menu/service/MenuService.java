package kr.co.markncompany.markorder.menu.service;

import kr.co.markncompany.markorder.menu.Menu;
import kr.co.markncompany.markorder.menu.dto.MenuDto;
import kr.co.markncompany.markorder.menu.repository.MenuRepository;
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

    /**
     * 메뉴 추가하기
     * @param menuDto
     */
    @Transactional
    public void insertMenu(MenuDto menuDto) {
        String id = "MN" + String.format("%04d", menuRepository.getSeq());
        menuDto.setId(id);

        Menu menu = new Menu(menuDto);
        menuRepository.save(menu);
    }

}
