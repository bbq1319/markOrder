package kr.co.markncompany.markorder.member.controller;

import kr.co.markncompany.markorder.member.entity.Member;
import kr.co.markncompany.markorder.member.repository.MemberRepository;
import kr.co.markncompany.markorder.security.JwtTokenProvider;
import kr.co.markncompany.markorder.security.PasswordEncryption;
import kr.co.markncompany.markorder.util.ClientInfoUtil;
import kr.co.markncompany.markorder.util.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @PostMapping("/signup")
    public ResponseEntity signup(Member member) throws Exception {
        memberRepository.save(member);
        return ResponseEntity.ok().body("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity login(Member member, HttpServletRequest request) throws Exception {
        Member m = memberRepository.findByMemberId(member.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 ID입니다."));

        if (!PasswordEncryption.mathes(member.getPassword(), m.getPassword()))
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        if (!m.isUseFlag())
            throw new IllegalArgumentException("비활성화된 사용자입니다. 관리자에게 문의해주세요.");

        String token = jwtTokenProvider.createToken(m.getUsername(), m.getRoles());
        CookieUtil.getNewCookie(token, m);

        String ip = ClientInfoUtil.getClientIp(request);
        String ua = ClientInfoUtil.getUserAgent(request);

        return ResponseEntity.ok().body("SUCCESS");
    }

}
