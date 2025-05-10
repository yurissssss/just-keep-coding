package ch17.sec06.exam01;

public class Student {
    private String name;
    private int score;

    //생성자
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //Getter
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
}
