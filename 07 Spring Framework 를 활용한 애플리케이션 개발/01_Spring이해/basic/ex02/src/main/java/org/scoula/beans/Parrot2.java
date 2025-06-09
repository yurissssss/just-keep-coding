package org.scoula.beans;

import org.springframework.stereotype.Component;

// 자동 등록되도록 지정
@Component
public class Parrot2 {
    // name을 "Koko"로 지정
    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
