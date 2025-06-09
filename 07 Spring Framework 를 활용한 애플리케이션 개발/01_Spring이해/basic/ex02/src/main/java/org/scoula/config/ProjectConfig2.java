package org.scoula.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula.beans")  // 컴포넌트 스캔을 통해 자동으로 빈을 등록
public class ProjectConfig2 {
}
