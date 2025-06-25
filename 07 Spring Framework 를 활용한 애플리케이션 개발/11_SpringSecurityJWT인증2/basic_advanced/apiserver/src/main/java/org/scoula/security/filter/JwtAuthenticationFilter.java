package org.scoula.security.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.security.util.JwtProcessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
@RequiredArgsConstructor
/**
 * OncePerRequestFilter 상속
 * 컨트롤러가 forward 했을 때 필터를 다시 통과하게 됨
 *      -> 이미 보안 필터는 통과했는데, 또 통과하게 됨
 * 요청 당 한 번만 필터가 동작
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER_PREFIX = "Bearer ";  // 끝에 공백 있음

    private final JwtProcessor jwtProcessor;
    private final UserDetailsService userDetailsService;

    // 토큰에서 사용자 정보를 추출, 인증 객체 생성
    private Authentication getAuthentication(String token) {
        String username = jwtProcessor.getUsername(token);
        UserDetails principal = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
    }

    /**
     * JWT 인증 필터 (요청 당 한 번만 동작)
     * Authorization 헤더에서 JWT 추출
     * 토큰 유효성 검사 후 SecurityContext에 인증 정보 저장
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
        if (bearerToken != null && bearerToken.startsWith(BEARER_PREFIX)) {
            String token = bearerToken.substring(BEARER_PREFIX.length());

            // 토큰에서 사용자 정보 추출 및 Authentication 객체 구성 후 SecurityContex에 저장
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        // 다음 필터로 넘김 (OncePerRequestFilter에서는 반드시 이렇게 호출해야 함)
        super.doFilter(request, response, filterChain);
    }
}