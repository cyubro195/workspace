import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_1 {
    public static void main(String[] arge) {

        //데이터에 순번이 존재, 데이터 중복이 가능
        List<String> list = new ArrayList<>();

        //데이터 key와 value 한 쌍으로 저장됨.
        Map<Integer, String> map = new HashMap<>();
        // 애는 2개 넣을 수 있음

        //map에 데이터 저장
        map.put(1, "java"); // 애가 데이터 넣는액 ( key : java )
        map.put(2, "python");
        map.put(3, "c++");
        // ▲ 애네는 for문 반복문 못돌림...
        //map 에 저장된 데이터 읽기(key 값으로 읽음!!)
        System.out.println(map.get(1)); //실행시키면 자바로 나옴
    }
}
