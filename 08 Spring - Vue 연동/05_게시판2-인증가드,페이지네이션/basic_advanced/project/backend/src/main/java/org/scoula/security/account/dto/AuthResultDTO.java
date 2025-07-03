package org.scoula.security.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AuthResultDTO
 *
 * 로그인 성공 시 클라이언트에게 반환되는 인증 결과 DTO.
 * token: JWT 또는 인증 토큰
 * user: 로그인한 사용자 정보 (username, role 등)
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResultDTO {
    String token;
    UserInfoDTO user;
}
