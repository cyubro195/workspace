package 다섯째_반복문.문제;

import java.util.Scanner;

public class For_test2 {
    public static void main(String[] args) {

        /*
        문제 : 출력문을 한번만 사용하여 0 ~ 5까지 출력

        for ( int i = 0; i < 6; i++ ){
            System.out.print(i);
        }
        */

       // 출력문을 한번만 사용하여 ‘2 4 6 8 10’을 출력

       // for( int i = 2; i < 11; i = i + 2){
       //     System.out.print(i + " ");
       // }

       //10 ~ 0 까지 출력
/*

       for ( int i = 10; i >= 0; i--){
           System.out.print(i);
       }
*/

        //1 ~ 100까지 숫자 중 3의 배수인 수의 개수를 For 사용
/*

        int cnt = 0;
        for (int i = 1; i < 101; i++){
            if (i % 3 == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);

*/

        //1 ~ 100까지의 숫자 중 5의 배수인 수를 모두 출력하고, 5의 배수인 수의 개수도 출력
/*

        int cnt = 0;
        for(int i = 1; i < 101; i++){
            if (i % 5 == 0) {
                cnt++;
                System.out.println(i);
            }

        }
        System.out.println();
        System.out.println( "5의 배수의 개수 : " + cnt );

*/

        // 임의의 정수를 입력받아 1부터 입력받은 수까지 중 짝수의 개수를 구하기

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : " );
        int num = sc.nextInt();
        int cnt = 0;

        for ( int i = 1; i < num + 1; i++ ){
            if (i % 2 == 0){
                cnt++;
            }
        }
        System.out.println(cnt);



    }

}
