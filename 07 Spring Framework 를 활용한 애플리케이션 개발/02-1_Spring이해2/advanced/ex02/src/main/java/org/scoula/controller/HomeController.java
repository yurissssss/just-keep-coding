package org.scoula.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 싱글톤으로 만들어주고, 스프링에 이 클래스가 컨트롤러 역할을 하는 클래스라고 등록시켜 줌.
@Controller
public class HomeController {

    // 요청 하나 당 함수 하나!
    // 요청이 어떻게 들어오는지 설정
    // 어떤 함수를 부를지 정의함

    // web.xml (순수 톰캣 웹앱)을 통해 홈을 index.jsp로 설정하던 방식과 다르게 설정!
    // web.xml: <welcome-file>index.jsp</welcome-file>
    // BUT web.xml에 없어도 톰캣이 index.jsp를 기본 welcome-file로 가지고 있음
    @GetMapping("/")  // "/"(root) 주소로 get요청이 들어오면
    public String home() {
        // 스프링이 핸들러매퍼에 주소와 방식에 따른 어떤 컨트롤러의 메서드를
        // 불러야 할지를 자동으로 등록시켜 줌.
        System.out.println(" ==== HomeController ==== ");
        return "index";  // view파일 이름 프론트컨트롤러에서 리턴함.

        // 뷰리졸버가 /WEB-INF/views/index.jsp를 붙여서
        // 프론트컨트롤러가 불러야 할 파일명으로 만들어줌. (렌더링)
    }
}
