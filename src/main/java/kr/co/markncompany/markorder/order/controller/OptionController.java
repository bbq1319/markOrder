package kr.co.markncompany.markorder.order.controller;

import kr.co.markncompany.markorder.order.Options;
import kr.co.markncompany.markorder.order.dto.OptionDto;
import kr.co.markncompany.markorder.order.dto.OptionGroupDto;
import kr.co.markncompany.markorder.order.repository.OptionRepository;
import kr.co.markncompany.markorder.order.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/option")
public class OptionController {

    private final OptionService optionService;
    private final OptionRepository optionRepository;

    @GetMapping("")
    public ResponseEntity option() {
        List<Options> optionList = optionRepository.findAll();
        if (optionList.size() > 0)
            return ResponseEntity.ok().body(optionList);
        else
            return ResponseEntity.badRequest().body("옵션 조회에 실패했습니다.");
    }


    /**
     * 옵션 저장
     *
     * @param optionDto
     * @param result
     * @return
     */
    @PostMapping("")
    public ResponseEntity insertOption(OptionDto optionDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("저장 중 오류가 발생했습니다.");
        }

        long id = optionService.insertOption(optionDto);
        if (id > 0)
            return ResponseEntity.ok().body("저장에 성공했습니다.");
        else
            return ResponseEntity.badRequest().body("저장에 실패했습니다.");
    }

    /**
     * 옵션그룹 저장
     *
     * @param optionGroupDto
     * @param result
     * @return
     */
    @PostMapping("/group")
    public ResponseEntity insertOptionGroup(OptionGroupDto optionGroupDto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("저장 중 오류가 발생했습니다.");
        }

        long id = optionService.insertOptionGroup(optionGroupDto);
        if (id > 0)
            return ResponseEntity.ok().body("저장에 성공했습니다.");
        else
            return ResponseEntity.badRequest().body("저장에 실패했습니다.");
    }

}
