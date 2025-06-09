package org.scoula.app;

import org.scoula.domain.Parrot;
import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ProjectConfig를 설정 클래스로 하여 Spring Context를 생성
        // -> ProjectConfig.class
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // 컨텍스트를 이용하여 Parrot 빈을 추출
        // -> context.getBean()
        Parrot p = context.getBean(Parrot.class);
        // 추출한 Parrot의 name 출력
        System.out.println(p.getName());
    }
}
