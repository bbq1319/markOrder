package kr.co.markncompany.markorder.member.transfer;

import kr.co.markncompany.markorder.member.Role;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class MemberResponse {

    private String token;
    private String memberId;
    private String name;
    private List<Role> roles;

}
