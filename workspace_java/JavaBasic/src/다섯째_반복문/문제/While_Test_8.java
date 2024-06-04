package 다섯째_반복문.문제;

// 임의의 정수를 입력받아 1부터 입력받은 수까지 중 짝수의 개수를 구하여라

import java.util.Scanner;

public class While_Test_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : " );
        int num = sc.nextInt(); // num = 10 넣는다고

        int i = 1;
        int cnt = 0; // 짝수를 정하는거
        while ( i < num + 1 ) { // i < 11 를 표현
            if ( i % 2 == 0) {
                cnt++;
            }
            i++;
        }
        System.out.println(cnt);

    }
}
