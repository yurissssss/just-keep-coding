package org.scoula.ex05.domain;

public class Member {
    // private -> 캡슐화
    private String name;
    private String userid;

    // 기본 생성자
    public Member() {}

    // 매개 변수가 있는 생성자
    public Member(String name, String userid) {
        this.name = name;
        this.userid = userid;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }
    public String getUserid() {
        return userid;
    }

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
}
