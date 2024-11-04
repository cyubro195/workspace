package 칠번째_메서드.문제;

import java.util.Scanner;

public class Test_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //int result = test1(50 , 60);
        //System.out.println(result);

        /*
        int a = sc.nextInt();
        System.out.println("입력 : ");
        int b = sc.nextInt();
        System.out.println("입력 : ");
        System.out.println("총 : " + a * b);
        */

        //int result = test3(40, 60);
        //System.out.println(result);

       //String text = test4("안녕","하셈");
       //System.out.println(text);

       //System.out.println(test5(40));

       //String result = test6(5);
       //System.out.println(result);

        //double a = test7(50);
        //System.out.println(a);

        //int result = test8(30,45,81);
        //System.out.println(result);

        System.out.println(test9(5));

    }
    // 메서드 2-9
    //한 정수를 매개변수로 받아, 1부터 매개변수로 받은 수까지 중
    //홀수의 합을 리턴하는 메소드를 선언하고 사용해보세요.

    // num = 정수
    public static int test9(int num){
        int sum = 0;
        for(int i = 1; i < num + 1; i++){
            if(i % 2 == 1){ //홀수
                sum = sum + i;
            }
        }
        return sum;
    }

    // 메서드 2-8
    public static double test8(int a, int b, int c){
        return (a + b + c) / 3.0;
    }

    // 메서드 2-7
    public static double test7(double a){
        return a * a; //제곱..
    }

    // 메서드 2-6
    public static String test6(int a){
        // 강제현변환은 정수랑 실수만 가능함..문자열은 안됨!
        // 정수 => 문자열
        String.valueOf(10); //"10"
        // 문자열 => 정수
        int aa = Integer.parseInt("10"); // 숫자로 바꿀수있는 문자열만!
        return a + "" ;
    }

    // 메서드 2-5
    public static String test5(int a){

        if ( a >= 90){
            return "A";
        }
        else if( a >= 70){
            return "B";
        }
        else {
            return "C";
        }
    }

    // 메서드 2-4
    public static String test4( String a, String b){
        return a + b;
    }
    // 메서드 2-3
    public static int test3(int a, int b){
        return a > b ? a : b; //삼합연산자로 풀이가능

        //if (a > b) {return a;}
        //else {return b;}
        // 둘 다 실행이 안될것도 생각해야함!
    }
    // 메서드 2-2
    public static int test2(int a, int b){
        return a * b;
    }
    // 메서드 2-1
    public static int test1( int a, int b){
        return a + b;
    }
}
