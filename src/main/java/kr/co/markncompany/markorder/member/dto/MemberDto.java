package kr.co.markncompany.markorder.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String id;
    private String memberId;
    private String password;
    private String name;
    private boolean useFlag;

}
