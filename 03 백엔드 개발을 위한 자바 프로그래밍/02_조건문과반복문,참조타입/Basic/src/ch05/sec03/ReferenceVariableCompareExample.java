package ch05.sec03;

public class ReferenceVariableCompareExample {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int[] arr3;

        arr1 = new int[] {1, 2, 3};
        arr2 = new int[] {1, 2, 3};
        arr3 = arr2;

        //같은 배열을 참조하는지
        System.out.println(arr1 == arr2);
        //false
        System.out.println(arr2 == arr3);
        //true
    }
}
