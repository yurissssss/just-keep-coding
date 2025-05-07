package ch12.sec03.exam02;

public class Student {
    private  int no;
    private String name;

    //Generate

    //멤버필드를 초기화하는 생성자
    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    //멤버필드에 대한 Getter 메서드
    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    //멤버필드에 대한 Setter 메서드
    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }
}