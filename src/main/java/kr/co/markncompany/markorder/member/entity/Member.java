package kr.co.markncompany.markorder.member.entity;

import kr.co.markncompany.markorder.common.BaseEntity;
import kr.co.markncompany.markorder.member.dto.MemberDto;
import kr.co.markncompany.markorder.security.PasswordEncryption;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String memberId;
    private String password;
    private String name;
    private boolean useFlag;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(joinColumns = @JoinColumn(name = "member_id"))
    private List<String> roles = new ArrayList<>();

    public Member(MemberDto memberDto) throws Exception {
        this.memberId = memberDto.getMemberId();
        this.password = PasswordEncryption.encryption(memberDto.getPassword());
        this.name = memberDto.getName();
        this.useFlag = true;
        this.roles = Arrays.asList("ROLE_ADMIN", "ROLE_USER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
