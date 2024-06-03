package 다섯째_반복문.While;

public class While_3 {
    public static void main(String[] args) {

        // 10부터 0까지 출력

        /*

        int i = 10;

        while (i >= 0){
            System.out.println(i);
            i--;
        }

        */

        // 1부터 20까지의 수 중에서 홀수만 출력

        /*
        int i = 1;
        while (i <= 20){
            System.out.println(i);
            i = i + 2; // 이러면 i가 3되니까 홀수가 되는거임!!!!

        }
        */

        // 다른방식, 가장 많이 쓰는 방식임!
        // 1부터 5까지의 수 중에서 짝수만 출력!
        int i = 1;
        while (i <= 5) {
            // 짝수만 출력
            if(i % 2 == 0) { // i이가 2로 나누었을 때 0
                System.out.println(i);
            }
            i++;
        // 반복문..쨩...어렵다..아..아ㅏ.ㅠ0ㅠ
        }


    }
}
