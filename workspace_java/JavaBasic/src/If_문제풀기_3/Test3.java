package If_문제풀기_3;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오 >>");
        int num = sc.nextInt();

        // 10의 자리와 1의 자리를 분리하는 작업

        // 십의 자리
        int tens = num/10;
        // 일의 자리
        int ones = num % 10;
        // 박수 횟수
        int clapCnt = 0;

        // 십의 자리가 3,6,9면 clapCnt를 1증가
        if (tens == 3 || tens ==6 || tens == 9) {
            clapCnt++;
            /*
            clapCnt++;
            ++clapCnt;
            clapCnt = clapCnt +1;
            clapCnt += 1;
            -> 다 되는애들!
            */

        }

        // 일의 자리가 3,6,9면 clapCnt를 1증가
        // 여기에 else if는 절대 주면 안댜!
        // 둘다 따로따로 줘야하기 때문에 if로 줘야함!
        if (ones == 3 || ones ==6 || ones == 9) {
            clapCnt++;
        }

        //clapCnt의 값에 따라 출력
        switch (clapCnt){
            case 1 :
                System.out.println("박수 짝");
                break;
            case 2 :
                System.out.println("박수 짝짝");
        }

    }
}
