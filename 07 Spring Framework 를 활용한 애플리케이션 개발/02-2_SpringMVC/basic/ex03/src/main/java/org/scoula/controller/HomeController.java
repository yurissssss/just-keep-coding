package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 싱글톤으로 만들어주고, 스프링에 이 클래스가 컨트롤러 역할을 하는 클래스라고 등록시켜 줌.
@Controller
@Log4j2
public class HomeController {

    @GetMapping("/")  // "/"(root) 주소로 get요청이 들어오면
    public String home(Model model) {
        model.addAttribute("name", "홍길동");
        System.out.println(" ==== HomeController ==== ");
        return "index";
    }
}
