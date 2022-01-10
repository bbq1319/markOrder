package kr.co.markncompany.markorder.member.controller;

import kr.co.markncompany.markorder.common.transfer.SuccessResponse;
import kr.co.markncompany.markorder.member.dto.MemberDto;
import kr.co.markncompany.markorder.member.entity.Member;
import kr.co.markncompany.markorder.member.repository.MemberRepository;
import kr.co.markncompany.markorder.member.transfer.MemberResponse;
import kr.co.markncompany.markorder.security.JwtTokenProvider;
import kr.co.markncompany.markorder.security.PasswordEncryption;
import kr.co.markncompany.markorder.util.ClientInfoUtil;
import kr.co.markncompany.markorder.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @PostMapping("/signup")
    public ResponseEntity signup(MemberDto memberDto) throws Exception {
        Member member = new Member(memberDto);
        memberRepository.save(member);
        return ResponseEntity.ok().body("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberDto memberDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Member member = memberRepository.findByMemberId(memberDto.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID입니다."));

        if (!PasswordEncryption.mathes(memberDto.getPassword(), member.getPassword()))
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        if (!member.isUseFlag())
            throw new IllegalArgumentException("비활성화된 사용자입니다. 관리자에게 문의해주세요.");

        String token = jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
        CookieUtil.getNewCookie(token, member, response);

        String ip = ClientInfoUtil.getClientIp(request);
        String ua = ClientInfoUtil.getUserAgent(request);

        return ResponseEntity.ok().body(new SuccessResponse<>(MemberResponse
                .builder()
                .token(token)
                .memberId(member.getMemberId())
                .name(member.getName())
                .roles(member.getRoles())
                .build()));
    }

}
