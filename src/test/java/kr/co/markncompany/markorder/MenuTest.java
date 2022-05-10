package kr.co.markncompany.markorder;

import kr.co.markncompany.markorder.menu.Menu;
import kr.co.markncompany.markorder.menu.dto.MenuDto;
import kr.co.markncompany.markorder.menu.repository.MenuCustomRepository;
import kr.co.markncompany.markorder.menu.repository.MenuRepository;
import kr.co.markncompany.markorder.menu.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuTest {

    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuCustomRepository menuCustomRepository;


    @Test
    void getMenuInfo() {
        Menu menu = menuRepository.findById("MN0001").orElseThrow();
        List<MenuDto> menuInfo = menuCustomRepository.getMenuInfoByMenuId(menu.getId());
        System.out.println(menuInfo);
    }

}
