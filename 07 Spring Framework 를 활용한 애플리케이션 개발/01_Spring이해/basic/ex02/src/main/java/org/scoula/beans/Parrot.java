package org.scoula.beans;

public class Parrot {
    // String name 속성과 Getter/Setter 추가
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString 추가
    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}
