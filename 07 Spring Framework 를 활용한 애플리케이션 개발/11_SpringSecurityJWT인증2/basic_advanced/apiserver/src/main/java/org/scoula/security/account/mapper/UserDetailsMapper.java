package org.scoula.security.account.mapper;

import org.scoula.security.account.domain.MemberVO;

public interface UserDetailsMapper {
    // 메서드 이름 = xml의 id
    public MemberVO get(String username);
}
