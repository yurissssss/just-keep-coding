package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {

    @RequestMapping("")  // 어떤 요청이든 매핑
    public void basic() {
        log.info("basic............");
    }

    // "/basic" 요청이 들어오면
    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get...........");
    }

    @GetMapping("/basicOnlyGet")  // get요청에만 매핑
    public void basicGet2(){
        log.info("basic get only get...........");
    }

    @GetMapping("/ex04")
    // "/ex04" 뒤에 올 쿼리스트링은 매개변수로 받음
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
        log.info("dto: " + dto);
        log.info("page: " + page);
        return "sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05...........");
    }

    @GetMapping("/ex06")
    public String ex06(RedirectAttributes ra) {
        log.info("/ex06...........");

        ra.addAttribute("name", "AAA");
        ra.addAttribute("age", "10");
        return "redirect:/sample/ex06-2";  // '/sample/ex06-2'로 리다이렉트
    }

    /**
     * 'http://localhost:8080/sample/ex06' 검색
     * -> 'http://localhost:8080/sample/ex06-2?name=AAA&age=10'로 이동
     */

    @GetMapping("/ex06-2")
    public void test() {
    }
}
