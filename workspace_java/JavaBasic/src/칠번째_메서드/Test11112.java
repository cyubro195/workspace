package 칠번째_메서드;

import java.sql.SQLOutput;

public class Test11112 {
    public static void main(String[] args) {
      // int num = 20;
      // printNum(num);

       int a = getNum(10,20);
       int b = getNum(10,20);
        System.out.println(a+b);
       // 실행결과를 되돌려준다 리턴!  되돌려받는 사람 => 우리
    }

    boolean b = isOdd(3);
    if(b){
        System.out.println(1);
    }

    if(isOdd(3)){
        System.out.println(1);
    }


    public static boolean isOdd(int num){
      return num % 2 == 1;
    }

    //void : 리턴하는 데이터 없음...ㅎㅎ

    public static void printNum(int num){
        //int num = 5;
        System.out.println(num);
    }

    public static int getNum(int a, int b){
       // int a = 10;
       // int b = 20;
        return a + b;
    }
    ////////////////////////////////////
    //* 다른 문법 *


}
