package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.security.account.domain.MemberVO;

import java.util.List;

/**
 * UserInfoDTO
 *
 * 인증된 사용자 정보를 클라이언트에 전달하기 위한 DTO.
 * 비밀번호 등 민감한 정보는 포함하지 않음
 * 주로 로그인 성공 시 응답에 포함되며, 사용자 권한 목록도 함께 제공
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    String username;
    String email;
    List<String> roles;

    public static UserInfoDTO of(MemberVO member) {
        return new UserInfoDTO(
                member.getUsername(),
                member.getEmail(),
                member.getAuthList().stream()
                        .map(a -> a.getAuth())
                        .toList()
        );
    }
}
