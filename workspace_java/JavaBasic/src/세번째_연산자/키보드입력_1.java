package 세번째_연산자;

import java.util.Scanner;
// Scanner는 꼭 자동완성으로 해야함! 안그럼 안뜸

public class 키보드입력_1 {
    public static void main(String[] args) {
        // 키보드 입력을 받을 수 있는 변수 생성 > 실무에서 잘 안씀.
        Scanner sc = new Scanner(System.in);

        // 정수 하나를 키보드로 입력
        int i = sc.nextInt(); // 키보드로 입력받으세요 라는 명렁어

        System.out.println("i = " + i);

    }
}
