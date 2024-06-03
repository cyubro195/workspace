package 네번째_조건문;

import java.util.Scanner;

public class Swith_예제_1 {
    public static void main(String[] args) {
        // 키보드로 정수 하나를 입력받아,
        // 입력받은 값이 짝수이면 '1' 출력
        // 홀수이면 '2' 를 출력하고
        // 그 밖에는 '0' 으로 출력
        // switch case break 해결해 보쟉

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : ");
        int num = sc.nextInt();
        int mod = num % 2;

        switch (mod){
            case 0 :
                System.out.println(1);
                break;
            case 1 :
                System.out.println(2);
                break;
            default:
                System.out.println(0);
        }





    }
}
