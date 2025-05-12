package ch15.sec04.exam01;

//import java.util.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExample {
    public static void main(String[] args) {
        //Map 컬렉션 생성 - 키: String, 값: Integer
        //int (X), Integer(O, class)
        Map<String, Integer> map = new HashMap<>();

        //객체 저장 - key가 중복되면, 새로운 값으로 대치됨
        map.put("신용권", 85);
        map.put("홍길동", 90);
        map.put("동장군", 80);
        map.put("신용권", 85);  // 동일한 key -> 덮어쓰기 됨
        //map.put("신용권", 100);
        System.out.println("총 Entry 수: " + map.size());
        //총 Entry 수: 3
        System.out.println();

        //키로 값 얻기
        String key = "홍길동";
        int value = map.get(key);
        System.out.println(key + " : " + value);  //홍길동 : 90
        System.out.println();

        //키 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        Set<String> keySet = map.keySet();  //모든 key를 Set 형태로 반환
        Iterator<String> keyIterator = keySet.iterator();
        while (keyIterator.hasNext()) {
            String k = keyIterator.next();
            Integer v = map.get(k);
            System.out.println(k + " : " + v);
            //map.put("신용권", 100); 라면
            //신용권 : 100
        }
        System.out.println();

        //엔트리 Set 컬렉션을 얻고, 반복해서 키와 값을 얻기
        //Entry: key-value
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Entry<String, Integer>> entryIterator = entrySet.iterator();
        while (entryIterator.hasNext()) {
            Entry<String, Integer> entry = entryIterator.next();
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + " : " + v);
        }
        System.out.println();

        //키로 엔트리 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수: " + map.size());
        //총 Entry 수: 2
        System.out.println();
    }
}
