package 다섯째_반복문.For;

import java.util.Scanner;

/*
    while(true){
    계속 만ㄴ족!
    }
 */
public class 무한루프 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) { // 무한루프 on
            System.out.println("점수 입력 : ");
            int num = sc.nextInt();

            if (num >= 0 && num <= 100) {
                break;
            }

        }

        System.out.println("무한루프에서 벗어났습니다.");





    }
}
