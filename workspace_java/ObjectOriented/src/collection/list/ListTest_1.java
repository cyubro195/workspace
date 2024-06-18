package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTest_1 {
    public static void main(String[] args) {

        //1. 문자열을 저장하는 리스트를 만들고 3개의 데이터를 넣어보자.
        // 그 후 리스트에 저장된 3개의 데이터를 출력해보라.

        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("hi");
        list1.add("bye");
        list1.add("bye bye 두바이야~~~");

        for (int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
/*
        //2. 정수를 저장할 수 있는 리스트를 만들고 5개의 정수를 scanner를 통해 입력받아 리스트에 저장한다.
        // 리스트에 저장된 모든 데이터의 합을 출력하여라.

        Scanner sc = new Scanner(System.in);
        List<Integer> test2 = new ArrayList();

        System.out.println("5개의 정수를 입력하세요");
        for (int i = 0; i < 5 ; i++){
            System.out.print("정수 입력 : ");
            int num = sc.nextInt();
            test2.add(num);
        }
        int sum = 0;
        for(int num : test2){
            //sum += num;
            sum = sum + num;
        }
        System.out.println("모든 데이터 출력의 합은 : " + sum);

        */
        //3. 이름을 저장하는 리스트 만들기 + 출력하기
            List<String> nameList = new ArrayList<>();
            nameList.add("김길동");
            nameList.add("고길동");
            nameList.add("박길동");
            nameList.add("오길동");
            nameList.add("강길동");

            for (int i =0; i < nameList.size(); i++){
                if (nameList.get(i).equals("오길동")){ //문자열 비교 넣기
                    System.out.println("해당입력이 존재합니다.");
                }
            }

        //4. 리스트 1~100까지 랜덤한 정수를 10개 넣어보자
        //저장된 데이터 중 짝수의 개수와 모든 짝수를 출력하는 프로그램을 만드세요.

        List<Integer> list = new ArrayList<>();
            //1~100사이의 랜덤정수 10개를 리스트에 저장
            for (int i =0; i <10; i++){
                int rand = (int) (Math.random() * 100 + 1);
                list.add(rand);
            }
            // 리스트에 저장된 짝수의 개수 및 모든 짝수 출력
            int cnt = 0; // 짝수가 된 저장값을 담는 변수???
            for (int e : list ){ //리스트에 저장된 하나하나가 e라는 뜻.
                if ( e % 2 == 0) {
                    cnt++;
                    System.out.println(e);
                }
            }
        System.out.println("cnt : " + cnt);

    }
}
