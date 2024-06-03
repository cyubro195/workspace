package 네번째_조건문;

import java.util.Scanner;

public class 예제_2 {
    public static void main(String[] args) {
        //키보드로 정수 하나를 입력받아,
        //입력받은 정수가 짝수이면 '1' 출력
        //그 밖의 숫자는 '2' 출력

        Scanner sc = new Scanner(System.in);

        System.out.println("정수 입력 : ");
        int num = sc.nextInt();

        if(num % 2 == 1){
            System.out.println(1);
        }
        else{
            System.out.println(2);
        }

    }
}
