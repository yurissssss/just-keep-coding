package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.scoula.ex03.dto.TodoDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void basicGet2() {
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

    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {
        log.info("" + dto);
        return "ex01";

        /**
         * log
         *
         * http://localhost:8080/sample/ex01
         * -> INFO  org.scoula.ex03.controller.SampleController(ex01:66) - SampleDTO(name=null, age=0)
         *
         * http://localhost:8080/sample/ex01?name=AAA&age=10
         * -> INFO  org.scoula.ex03.controller.SampleController(ex01:66) - SampleDTO(name=AAA, age=10)
         */
    }

    @GetMapping("/ex02")
    public String ex02(
            @RequestParam("name") String name,
            @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";

        /**
         * log
         *
         * http://localhost:8080/sample/ex02?name=AAA&age=10
         * -> INFO  org.scoula.ex03.controller.SampleController(ex02:81) - name: AAA
         * -> INFO  org.scoula.ex03.controller.SampleController(ex02:82) - age: 10
         *
         * http://localhost:8080/sample/ex02?age=10
         * http://localhost:8080/sample/ex02?name=AAA
         * -> (오류) WARN  org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver(logException:208)
         *          - Resolved [org.springframework.web.bind.MissingServletRequestParameterException:
         *          Required request parameter 'name' for method parameter type String is not present]
         */
    }

    // 쿼리 파라미터가 여러 개 전달된 경우

    /**
     * @GetMapping("/ex02List") public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
     * log.info("ids: " + ids);
     * return "ex02List";
     * <p>
     * // log
     * // http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333
     * // -> INFO  org.scoula.ex03.controller.SampleController(ex02List:106) - ids: [111, 222, 333]
     * }
     */

    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") String[] ids) {
        log.info("array ids: " + Arrays.toString(ids));
        return "ex02List";

        /**
         * log
         *
         * http://localhost:8080/sample/ex02List?ids=111&ids=222&ids=333
         * -> INFO  org.scoula.ex03.controller.SampleController(ex02List:122) - array ids: [111, 222, 333]
         */
    }

    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info("todo: " + todo);
        return "ex03";

        /**
         * log
         *
         * http://localhost:8080/sample/ex03?title=test&dueDate=2023-01-01
         * -> INFO  org.scoula.ex03.controller.SampleController(ex03:137) - todo: TodoDTO(title=test, dueDate=Sun Jan 01 00:00:00 KST 2023)
         */
    }

    @GetMapping("/ex07")
    public @ResponseBody SampleDTO ex07() {
        log.info("/ex07........");
        SampleDTO dto = new SampleDTO();
        dto.setAge(10);
        dto.setName("홍길동");

        return dto;

        /**
         * http://localhost:8080/sample/ex07
         * -> {
         *      "name": "홍길동",
         *      "age": 10
         *    }
         * log -> INFO  org.scoula.ex03.controller.SampleController(ex07:149) - /ex07........
         *
         */
    }

    @GetMapping("/ex08")
    public ResponseEntity<String> ex08() {
        log.info("/ex08..........");

        // {"name": "홍길동"}
        String msg = "{\"name\": \"홍길동\"}";

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type", "application/json;charset=UTF-8");
        return new ResponseEntity<>(msg, header, HttpStatus.OK);
    }

    @GetMapping("/exUpload")
    public void exUpload() {
        log.info("/exUpload..........");
    }

    @PostMapping("/exUploadPost")
    public void exUploadPost(ArrayList<MultipartFile> files) {
        for (MultipartFile file : files) {
            log.info("----------------------------------");
            log.info("name:" + file.getOriginalFilename());
            log.info("size:" + file.getSize());
        }
    }

}
