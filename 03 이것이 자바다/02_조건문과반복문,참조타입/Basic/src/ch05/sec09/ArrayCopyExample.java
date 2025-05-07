package ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldStrArray = {"java", "array", "copy"};

        //요소가 5개인 새로운 배열 선언
        String[] newStrArray = new String[5];

        //배열 요소 복사
        //System.arraycopy(원본배열, 복사시작인덱스, 새배열, 불여넣기시작인덱스, 복사요소수)
        System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
        //java, array, copy, null, null,

        //베열 요소 출력
        for (int i=0; i<newStrArray.length; i++) {
            System.out.print(newStrArray[i] + ", ");
        }
    }
}
