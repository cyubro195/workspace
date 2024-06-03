package 다섯째_반복문.While;

public class While_Test_5 {
    public static void main(String[] args) {

        /*

        1~5까지 합을 구하는 코드
        int i = 1; > 반복 시작점
        int sum = 0; > 1~5까지의 합을 저장할 변수

        while( i < 6 ){
            sum = sum + i;
            i++;
        }

        */

        // while문을 사용하여 1 ~ 10까지의 합을 구하여라.

        int i = 1;
        int sum = 0;

        while (i < 11) {
            sum = sum + i;
            i++;
        }
        System.out.println(sum);
    }
}
