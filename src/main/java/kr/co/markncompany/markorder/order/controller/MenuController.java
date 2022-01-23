package kr.co.markncompany.markorder.order.controller;

import kr.co.markncompany.markorder.common.transfer.ErrorResponse;
import kr.co.markncompany.markorder.order.Menu;
import kr.co.markncompany.markorder.order.dto.MenuDto;
import kr.co.markncompany.markorder.order.dto.MenuGroupDto;
import kr.co.markncompany.markorder.order.dto.MenuOptionGroupDto;
import kr.co.markncompany.markorder.order.repository.MenuCustomRepository;
import kr.co.markncompany.markorder.order.repository.MenuRepository;
import kr.co.markncompany.markorder.order.service.MenuService;
import kr.co.markncompany.markorder.util.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/v1/menu")
public class MenuController {

    private final MenuService menuService;
    private final MenuRepository menuRepository;
    private final MenuCustomRepository menuCustomRepository;

    @GetMapping("")
    public ResponseEntity menu(HttpServletRequest request) {
        if (!TokenUtil.checkJwt(request))
            return new ResponseEntity(new ErrorResponse("invalid token"), HttpStatus.UNAUTHORIZED);

        List<MenuDto> menuList = menuCustomRepository.getMenuList();
        if (menuList.size() > 0)
            return ResponseEntity.ok().body(menuList);
        else
            return ResponseEntity.badRequest().body("메뉴 조회에 실패했습니다.");
    }

    @GetMapping("{id}")
    public ResponseEntity getMenuInfo(@PathVariable Optional<Long> id, HttpServletRequest request) {
        if (!TokenUtil.checkJwt(request))
            return new ResponseEntity(new ErrorResponse("invalid token"), HttpStatus.UNAUTHORIZED);

        if (id.isPresent()) {
            Long menuId = id.get();
            Menu menu = menuRepository.findById(menuId)
                    .orElseThrow(() -> new IllegalArgumentException("메뉴 조회 실패"));

            return ResponseEntity.ok().body(menu);
        }

        return ResponseEntity.badRequest().body("메뉴 ID 조회 실패");
    }

    /**
     * 메뉴 저장
     *
     * @param menuDto
     * @param result
     * @return
     */
    @PostMapping("")
    public ResponseEntity insertMenu(MenuDto menuDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("저장 중 오류가 발생했습니다.");
        }

        long id = menuService.insertMenu(menuDto);
        if (id > 0)
            return ResponseEntity.ok().body("저장에 성공했습니다.");
        else
            return ResponseEntity.badRequest().body("저장에 실패했습니다.");
    }

    /**
     * 메뉴그룹 저장
     *
     * @param menuGroupDto
     * @param result
     * @return
     */
    @PostMapping("/group")
    public ResponseEntity insertMenuGroup(MenuGroupDto menuGroupDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("저장 중 오류가 발생했습니다.");
        }

        long id = menuService.insertMenuGroup(menuGroupDto);
        if (id > 0)
            return ResponseEntity.ok().body("저장에 성공했습니다.");
        else
            return ResponseEntity.badRequest().body("저장에 실패했습니다.");
    }

    /**
     * 메뉴옵션그룹 저장
     *
     * @param menuOptionGroupDto
     * @param result
     * @return
     */
    @PostMapping("/option-group")
    public ResponseEntity insertMenuOptionGroup(MenuOptionGroupDto menuOptionGroupDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("저장 중 오류가 발생했습니다.");
        }

        long id = menuService.insertMenuOptionGroup(menuOptionGroupDto);
        if (id > 0)
            return ResponseEntity.ok().body("저장에 성공했습니다.");
        else
            return ResponseEntity.badRequest().body("저장에 실패했습니다.");
    }

}
