package org.scoula.security.account.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;

import javax.servlet.http.HttpServletRequest;

/**
 * LoginDTO
 *
 * 로그인 요청 시 클라이언트로부터 전달받은 username과 password를 담는 DTO.
 * 주로 JSON 형태로 전달된 로그인 정보를 매핑하는 데 사용됨.
 * of(HttpServletRequest)를 통해 요청 바디에서 직접 파싱 가능.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDTO {
    private String username;
    private String password;

    public static LoginDTO of(HttpServletRequest request) {
        ObjectMapper om = new ObjectMapper();
        try {
            // getInputStream(): body를 그대로 읽어와줘
            return om.readValue(request.getInputStream(), LoginDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            // 인증 관련 예외 처리
            throw new BadCredentialsException("username 또는 password가 없습니다.");
        }
    }
}
