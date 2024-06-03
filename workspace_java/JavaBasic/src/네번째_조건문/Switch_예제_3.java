package 네번째_조건문;

import java.util.Scanner;

/*
    점수를 키보드로 입력받음 (정수)
    키보드로 입력 받은 점수가
    90 <= X <= 100 'A'출력
    80 <= X <= 89 'B'출력
    70 <= X <= 79 'C'출력
    x < 70 'D'출력
*/
public class Switch_예제_3 {
    public static void main(String[] args) {


        System.out.println("점수를 입력하셈: ");


        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();


        // 힌트 : 정수와 정수의 연산결과는 무조건 정수!
        // 91 / 10 -> 9 ?????????

        switch (score / 10){

            case 10:

            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            default:
                System.out.println("D");

        }



    }
}
