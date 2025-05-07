package ch02.sec10;

public class PrimitiveAndStringConversationExample {
    public static void main(String[] args) {
        //String -> int
        int value1 = Integer.parseInt("10");
        //String -> double
        double value2 = Double.parseDouble("3.14");
        //String -> boolean
        boolean value3 = Boolean.parseBoolean("true");

        System.out.println("value1: " + value1);
        //value1: 10
        System.out.println("value2: " + value2);
        //value2: 3.14
        System.out.println("value3: " + value3);
        //value3: true

        //int -> String
        String str1 = String.valueOf(10);
        //double -> String
        String str2 = String.valueOf(3.14);
        //boolean -> String
        String str3 = String.valueOf(true);

        System.out.println("str1: " + str1);
        //str1: 10
        System.out.println("str2: " + str2);
        //str2: 3.14
        System.out.println("str3: " + str3);
        //str3: true
    }
}
