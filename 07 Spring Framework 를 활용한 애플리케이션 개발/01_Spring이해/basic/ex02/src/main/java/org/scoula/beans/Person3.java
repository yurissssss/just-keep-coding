package org.scoula.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 빈으로 자동 등록되도록 지정
@Component
public class Person3 {
    // name을 "Ella"로 지정
    private String name = "Ella";

    private final Parrot2 parrot;

    // Parrot2를 생성자 주입을 통해 자동 설정
    @Autowired
    public Person3(Parrot2 parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // final이라서 setParrot (X)

    public Parrot2 getParrot() {
        return parrot;
    }
}
