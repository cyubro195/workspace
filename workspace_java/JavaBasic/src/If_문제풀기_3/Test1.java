package If_문제풀기_3;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" 첫번째 변의 길이 : ");
        int a = sc.nextInt();

        System.out.println(" 두번째 변의 길이 : ");
        int b = sc.nextInt();

        System.out.println(" 세번째 변의 길이 : ");
        int c = sc.nextInt();

        if ( a+b > c && b+c > a && a+c > b ) {
            System.out.println(" 삼각형 쌉가능 ");
        }
        else {
            System.out.println(" 삼각형 불가능 ");
        }
    }
}
