package 칠번째_메서드.문제;

import java.util.Scanner;

public class Test_1 {
    public static void main(String[] args) {


        //test1();
        //test2_1();
        //test2_2();
        // test3(5);
        // test4("java");
        //test5(10 ,20);
        // test6(1,1,1);
        // test7
        // test8(집에,가고싶다);
        /*
        test9_1("홍길동");
        test9_2(23);
        test9_3("울산");
        */
        // test10("김주주",10,"서울");

        Scanner sc = new Scanner(System.in);
        /*String name = sc.next();
        int age = sc.nextInt();
        String addr = sc.next();
        test10 (name,age,addr);*/
        // test14(13);
        // test16(5);
        //test17(5,1);
        // test18(1,10);
        test19("집에가자",10);
    }

    //1번 메서드
    public static void test1(){
        System.out.println("안녕하세요~");
    }
    //2번 메서드
    public static void test2_1(){
        System.out.print("반갑습니다,");
    }
    public static void test2_2(){
        System.out.print("어서오세요~");
    }

    //3번 메서드
    public static void test3(int num){
        System.out.println(num);
    }

    //4번 메서드
    public static void test4(String str){
        System.out.println(str);
    }
    //5번 메서드
    public static void test5(int a, int b){
        System.out.println(a+b);
    }

    //6번 메서드
    public static void test6(int a, int b, int c){
        System.out.println(a*b*c);

    }

    //7번 메서드
    public static void test7(int a, int b){
        System.out.println("몫 : " + a / b);
        System.out.println("나머지 : " + a % b);

    }

    //8번 메서드
    public static void test8(String s1, String s2){
        System.out.println(s1+s2);

    }

    // 9번 메서드

    public static void test9_1(String name){
        System.out.println(name);
    }
    public static void test9_2(int age){
        System.out.println(age);
    }
    public static void test9_3(String addr){
        System.out.println(addr);
    }

    // 10번 메서드 - 9번을 하나로 뭉치는거임

    public static void test10(String name, int age, String addr){
        test9_1(name);
        test9_2(age);
        test9_3(addr);

    }

    // 12번 메서등

    // 14번 메서드


    public static void test14(int num){

        //삼항연산자
        // int a = 10 > 5 ? 1 : 2;
        // ? 앞에 있는 10>5는 '참'또는'거짓'을 나타내는
        // 1은 앞에 10 > 5 조건이 참 일 때
        // 2는 앞에 10 > 5가 거짓일때
        // 뜻 : 10이 5보다 큰가? ㅇㅇ 1이 나옴ㅎ


/*
        기본정석으로 풀이

        if(num % 2 == 0){
            System.out.println("짝수");
        }
        else {
            System.out.println("홀수");
        }

*/
        // 삼항연산자로 풀어보기
        System.out.println(num % 2 == 0 ? "짝수" : "홀수"); // if+else를 활용할때 간단하게 풀이할수있음!
    }

    //15번 메서드

    public static void test15(int a, int b){
        if (a % 2 == 0 && b % 2 == 0) {
            System.out.println(" 둘 다 짝수임");
        }
        else if (a % 2 == 0 && b % 2 != 0) {
            System.out.println(" 둘 다 홀수임");
        }
        else {
            System.out.println("하나만 짝수임");
        }
    }

    // 16번 메서드

    public static void test16(int num){
        for(int i = 0; i < num + 1 ; i++){
            System.out.println(i);
        }
    }

    //17번 메서드

    //1 5 -> 2 3 4
    public static void test17(int a, int b){
        int max = a > b ? a : b; //5
        int min = a < b ? a : b; //1

        for(int i = min + 1; i < max ; i++){
            System.out.println(i);
        }
    }

    //18번 메서드

    public static void test18(int a, int b){
        int max = a > b ? a : b; //5
        int min = a < b ? a : b; //1

        int cnt = 0;
        for(int i = min + 1; i < max ; i++){
            if (i % 5 == 0) {
                cnt++; // 5의배수면 1씩 증가
            }
        }
        System.out.println(cnt);
    }

    // 19번 메서드
    // 한 문자열과 정수를 매개변수로 받아,
    // 매개변수로 받은 문자열을 매개변수로 받은
    // 숫자만큼 반복 출력하는 메소드를 선언하고 호출해보세요.

    public static void test19(String s, int num){
        String result = ""; // 반복문자
        for(int i = 0; i < num ; i++){
            result = result + s;
        }
        System.out.println(result);
    }



}
