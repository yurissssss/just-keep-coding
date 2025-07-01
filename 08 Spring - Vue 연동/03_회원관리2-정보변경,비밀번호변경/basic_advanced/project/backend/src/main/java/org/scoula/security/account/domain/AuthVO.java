package org.scoula.security.account.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Data  // getter, setter 생성
public class AuthVO implements GrantedAuthority {
    private String username;  // 사용자 ID
    /**
     * role(역할) 정보
     *
     * DB: 'ROLE_ADMIN', 'ROLE_MEMBER' 등으로 저장됨 (접두사 'ROLE_' 필수)
     * Spring Security: 기본적으로 'ROLE_' 접두사가 붙은 문자열을 권한으로 인식함
     *      ex) hasRole("ADMIN") -> 내부적으로는 "ROLE_ADMIN"과 비교
     * -> DB에 저장할 때는 반드시 'ROLE_' 접두사를 포함해야 함
     */
    private String auth;

    @Override
    public String getAuthority() {
        return auth;
    }
}
