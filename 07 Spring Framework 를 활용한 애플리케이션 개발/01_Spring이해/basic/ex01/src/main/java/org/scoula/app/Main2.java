package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.config.ProjectConfig2;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        // ProjectConfig2를 설정 클래스로 하여 Spring Context를 생성
        // -> ProjectConfig2.class
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

        // 컨텍스트를 이용하여 "miki"이름의 빈을 추출
        // -> context.getBean()
        Parrot p = context.getBean("miki", Parrot.class);
        // 추출된 Parrot의 name 출력
        System.out.println(p.getName());
    }
}
