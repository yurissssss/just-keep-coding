package org.scoula.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * RootConfig -> 보통 @Service, @Repository, @Component들을 대상으로 설정
 * ServletConfig -> @Controller와 관련된 Bean을 다룸 -> 스캔 등록
 */

@EnableWebMvc
@ComponentScan(basePackages = {"org.scoula.controller",
        "org.scoula.ex03.controller"})			// Spring MVC용 컴포넌트 등록을 위한 스캔 패키지
public class ServletConfig implements WebMvcConfigurer {

    // 프론트파일(css, js, img)의 위치를 지정해주는 함수
    // /resources/img/a.png라고 요청이 들어오면
    // /resources/ 밑에 찾겠다라는 설정
    // <img src="/resources/img/a.png">
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")     // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/");    // webapp/resources/경로로 매핑
    }
    // jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }
}