package kr.co.markncompany.markorder.order.controller;

import kr.co.markncompany.markorder.order.Menu;
import kr.co.markncompany.markorder.order.repository.MenuRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MenuController {

    private final MenuRepository menuRepository;

    @GetMapping("/menu")
    public ResponseEntity menu() {
        List<Menu> menuList = menuRepository.findAll();
        if (menuList.size() > 0)
            return ResponseEntity.ok().body(menuList);
        else
            return ResponseEntity.badRequest().body("메뉴 조회에 실패했습니다.");
    }

    @PostMapping("/menu")
    public ResponseEntity insertMenu() {

        return ResponseEntity.ok().body("저장에 성공했습니다");
    }



}
