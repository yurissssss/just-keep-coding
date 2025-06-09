package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Parrot 클래스를 컴포넌트 스캔을 통해 빈으로 자동 등록되도록 설정 클래스 정의
@Configuration
@ComponentScan(basePackages = "org.scoula.domain")
public class ProjectConfig3 {

}
