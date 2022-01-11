package kr.co.markncompany.markorder.common;

import kr.co.markncompany.markorder.common.transfer.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity illegalArgumentException(IllegalArgumentException e) {
        if (e != null && e.getMessage() != null)
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));

        return ResponseEntity.badRequest().body(new ErrorResponse("알 수 없는 에러가 발생했습니다."));
    }

}
