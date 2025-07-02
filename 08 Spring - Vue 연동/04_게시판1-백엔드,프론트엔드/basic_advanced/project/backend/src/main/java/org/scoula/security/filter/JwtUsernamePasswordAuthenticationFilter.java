package org.scoula.security.filter;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.dto.LoginDTO;
import org.scoula.security.handler.LoginFailureHandler;
import org.scoula.security.handler.LoginSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    // 스프링 생성자 주입을 통해 전달
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager,  // SecurityConfig가 생성된 이후에 등록됨
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler) {
        super(authenticationManager);

        setFilterProcessesUrl("/api/auth/login");  // 필터 적용 주소 (POST 로그인 요청 url)
        setAuthenticationSuccessHandler(loginSuccessHandler);  // 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler);  // 로그인 실패 핸들로 등록
    }

    // 로그인 요청 url인 경우, 로그인 작업 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        // 1. http body에 들어온 json --> dto(LoginDTO.of())
        //  요청 BODY의 JSON에서 username, password -> LoginDTO
        LoginDTO login = LoginDTO.of(request);

        // 2. 인증 토큰(UsernamePasswordAuthenticationToken) 구성
        //  인증해달라고 인증매니저에게 요청!
        //  인증매니저에게 로그인 정보를 줄 때는 Token 객체를 만들어서 주어야 함.
        //  인증정보 Token 만들기 (<-- dto)
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        // 3. AuthenticationManager에게 인증 요청
        //  인증매니저에 토큰 주면서 인증해줘라고 요청
        //  --> 성공하면 Authentication 객체를 생성해서 리턴해줌.
        return getAuthenticationManager().authenticate(authenticationToken);
    }
}
