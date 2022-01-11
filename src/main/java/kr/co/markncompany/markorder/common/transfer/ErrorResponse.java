package kr.co.markncompany.markorder.common.transfer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

    private boolean isSuccess = false;
    private String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

}
