package ch15.sec03.exam02;

public class Member {
    public String name;
    public int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //name & age 값 같으면 -> 동일한 hashCode 값 리턴
    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    //name & age 값 같으면 -> 'true' 리턴
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member target) {
            return target.name.equals(name)  && (target.age == age);
        } else {
            return false;
        }
    }
}
