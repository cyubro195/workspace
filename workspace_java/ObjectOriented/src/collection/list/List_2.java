package collection.list;

import java.util.ArrayList;
import java.util.List;

public class List_2 {
    public static void main(String[] args) {

        //정수를 다수 저장할 수 있는 list 생성
        List<Integer> list = new ArrayList<>();

        list.add(20);
        list.add(10);
        list.add(18);
        list.add(28);

        // 데이터빽귀
        int a = list.get(1);
    }
}
