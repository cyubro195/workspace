package 칠번째_메서드;

import java.nio.channels.Pipe;
import java.util.Scanner;

public class Test_1_1_4 {

/*    //11법
    public static void main(String[] args) {
        int num = 10;
        test11(num);
    }
    public static void test11(int num){
        System.out.println(" 숫자 " + num);
    }
*/

    //12번
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();
        System.out.println("이름 : ");
        int age = sc.nextInt();
        System.out.println("나이 : ");

        System.out.println("주소 : ");

    }
    public static void test12(String name, int age, String addr){
        System.out.println("이름 " + name);
        System.out.println(age);
        System.out.println(addr);
    }
/*

    //13번
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        test13(x,y);
    }

    public static void test13(int num1, int num2){
        System.out.println(num1+num2);
    }
*/



}
