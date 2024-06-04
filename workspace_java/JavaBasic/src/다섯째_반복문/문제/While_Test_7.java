package 다섯째_반복문.문제;

//1 ~ 100까지의 숫자 중 5의 배수인 수를 모두 출력하고,
// 5의 배수인 수의 개수도 출력하되, while문을 사용하여라.

public class While_Test_7 {
    public static void main(String[] args) {

        int i = 1;
        int cnt = 0;

        //너가 5의 배수야??
        while ( i < 101 ) {
            if ( i % 5 == 0) {
                cnt++;
                System.out.print(i + " "); // 5의 배수를 출력
            }
            i++;
        }
        System.out.println();
        System.out.println( "5의 배수의 개수 : " + cnt );





    }
}
