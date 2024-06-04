package 다섯째_반복문.문제;

public class While_Test_3 {
    public static void main(String[] args) {
        // 출력문을 한번만 사용하여 ‘2 4 6 8 10’을 출력하되, while문을 사용하여라.

        // 1번 방법
        int i = 2;
        while (i < 11) {
            System.out.print(i + ""); // 프린트로 출력하면 가로로 쭊~~~~
            i = i + 2; //2씩 증가하게 만들기!
        }


        // 2번 방법

        int j = 2;
        while (j < 11) {
            // j가 짝수일때만 출력하겠다. 입력
            if(j % 2 == 0){
                System.out.print(i + "");
            }
            j++;
        }



    }
}
