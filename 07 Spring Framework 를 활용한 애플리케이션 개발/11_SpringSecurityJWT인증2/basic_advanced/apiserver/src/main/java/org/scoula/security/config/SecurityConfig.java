package org.scoula.security.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.scoula.security.filter.AuthenticationErrorFilter;
import org.scoula.security.filter.JwtAuthenticationFilter;
import org.scoula.security.filter.JwtUsernamePasswordAuthenticationFilter;
import org.scoula.security.handler.CustomAccessDeniedHandler;
import org.scoula.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@Log4j2
@MapperScan(basePackages = {"org.scoula.security.account.mapper"})
@ComponentScan(basePackages = {"org.scoula.security"})
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationErrorFilter authenticationErrorFilter;

    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;


    // 문자셋 필터
    public CharacterEncodingFilter encodingFilter() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return encodingFilter;
    }

    @Autowired
    private JwtUsernamePasswordAuthenticationFilter jwtUsernamePasswordAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager 빈 등록
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // cross origin 접근 허용
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    // 접근 제한 무시 경로 설정 - resource
    // Spring Security 필터 체인을 거치지 X, 무시
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/*", "/api/member/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 한글 인코딩 필터 설정
        http.addFilterBefore(encodingFilter(), CsrfFilter.class)
                // 로그인 인증 필터: 로그인 시 JWT 발급
                .addFilterBefore(jwtUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // jwt 인증 필터: 요청 시 토큰 토큰 유무 검사 및 인증 객체 설정
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 인증 에러 필터: 만료된 토큰 등 예외 처리
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class);

        http.httpBasic().disable()  // 기본 HTTP 인증 비활성화
                .csrf().disable()  // CSRF 비활성화
                .formLogin().disable()  // formLogin 비활성화 관련 필터 해제
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // 세션 생성 모드 설정

        /** 경로별 접근 권한 설정
         * /security/all: 모두 접근 가능
         * /security/admin: 'ROLE_ADMIN' or 'ROLE_MEMBER' 권한인 경우 접근 가능
         * /security/member:'ROLE_MEMBER' 권한인 경우 접근 가능
         */

        //form-login 기본 설정은 비활성화되어서 사라짐
        http.authorizeRequests().antMatchers("/security/all").permitAll()
                .antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/security/member").access("hasAnyRole('ROLE_MEMBER', 'ROLE_ADMIN')");

        http
                .authorizeRequests() // 경로별 접근 권한 설정
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/api/security/all").permitAll()        // 모두 허용
                .antMatchers("/api/security/member").access("hasRole('ROLE_MEMBER')")    // ROLE_MEMBER 이상 접근 허용
                .antMatchers("/api/security/admin").access("hasRole('ROLE_ADMIN')")      // ROLE_ADMIN 이상 접근 허용
                .anyRequest().authenticated();  // 나머지는 로그인 된 경우 모두 허용


        // 권한이 없으면 403 에러 화면이 뜸.
        // -> 이 에러화면보다는 로그 페이지를 보여주는 것이 더 나을 것 같음.
        // --> 403 에러가 발생했을 때 form-login화면으로 다시 redirect!
        http.formLogin(); // form 기반 로그인 활성화, 나머지는 모두 디폴트

        // 예외 처리 설정
        http
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);

        // 로그인 페이지 커스텀
        http.formLogin()  // 로그인 설정 시작
                .loginPage("/security/login")  // 로그인 페이지 GET URL -> 'security/login' 뷰(jsp) 정의
                .loginProcessingUrl("/security/login")  // 로그인 POST URL -> login form의 action에 지정
                .defaultSuccessUrl("/");  // 로그인 성공 시 redirect할 페이지 (첫 페이지)

        http.logout()  // 로그아웃설정시작
                .logoutUrl("/security/logout")  // POST: 로그아웃 호출 url
                .invalidateHttpSession(true)  // 세션 invalidate
                .deleteCookies("remember-me", "JSESSION-ID")  // 삭제할 쿠키 목록
                .logoutSuccessUrl("/security/logout");  // GET: 로그아웃 이후이동할페이지

    }

    // AuthenticationManager 구성
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        log.info("configure..............................");

        // in memory user 정보 삭제 -> UserDetailsService와 같이 사용 불가
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());

        /**
         * auth.inMemoryAuthentication()
         *         .withUser("admin")
         *         //.password("{noop}1234")
         *         .password("$2a$10$PJan94OZyo6fLLjlTKHYredvcnmd23pgEoIsjr1M.bq3yySWd5Gou")
         *         .roles("ADMIN", "MEMBER");  // ROLE_ADMIN
         *
         * auth.inMemoryAuthentication()
         *         .withUser("member")
         *         //.password("{noop}1234")
         *         .password("$2a$10$PJan94OZyo6fLLjlTKHYredvcnmd23pgEoIsjr1M.bq3yySWd5Gou")
         *         .roles("MEMBER");  // ROLE_MEMBER
         */
    }
}
