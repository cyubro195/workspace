package 다섯째_반복문.문제;

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
        int sum = 0; // 결과가 들어오는 곳!

        while (i < 11) { // i <= 5 > 이것도 맞긴한데 실무에서는 이렇게 잘 안씀!
            sum = sum + i; // sum += i; 둘 다 똑같은 말
            i++;
        }
        System.out.println(sum); // 안에 넣으면 계속 나오기 떄문에 반복문 밖에 빼야함!
    }
}
