package If_문제풀기_2;

import java.util.Scanner;

public class Test_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        int max; // 큰 수를 저장하기 위해
        int min; // 작은수를 저장하기 위해

        System.out.print("첫 번째 수 : "); // > 제일 중요한거 print 로 해야 띄어쓰기가 됨! 이것도 조심해야함!
        int num1 = sc.nextInt();
        System.out.print("두 번째 수 : ");
        int num2 = sc.nextInt();

        if (num1 > num2) {
            max = num1;
            min = num2;
        }
        else {
            max = num2;
            min = num1;
        }
        System.out.println(max + ">" + min);
    }
}
