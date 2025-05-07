package ch13.sec02.exam01;

//타입 파라미터: K, M
public class Product<K, M> {
    //필드 선언
    private K kind;
    private M model;

    //Getter 메서드
    //리턴 타입에 타입 파라미터 사용
    // -> 타입 파라미터에 따라 자동 변환
    public K getKind() {return this.kind;}
    public M getModel() {return this.model;}
    //Setter 메서드
    //매개변수 타입에 타입 파라미터 사용
    public void setKind(K kind) {this.kind = kind;}
    public void setModel(M model) {this.model = model;}
}
