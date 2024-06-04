package 다섯째_반복문.For;

public class For_1 {
    public static void main(String[] args) {

        // while문으로 1~10까지 출력
        /*

         int i = 1;

        while (i < 11) { //<<반복문에서 제일 중요한!
            System.out.println(i);
            i++; // <<반복문에서 제일 중요한!
        }
        */

        // For문으로 변경하기 !

        /*
        for ( int i = 1; i < 11; i++ ){ // 마지막에는 ;를 넣지말기!
            System.out.println(i); // 애가 마지막이 아니고 3번째로 해석해야함! 마지막이 i++;
        }
        */

        // 1~10까지 합..
        int sum = 0;
        for ( int i = 1; i < 11; i++){
            sum = sum + i;
        }
        System.out.println(sum);





    }
}
