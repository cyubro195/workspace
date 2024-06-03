package If_문제풀기_1;

public class Test_4 {
    public static void main(String[] args) {
        /*
        정수형 변수 하나를 선언하고 임의의 정수로 초기화하자.
        그리고 변수의 값이 3의 배수이면 ‘3의 배수입니다’를 출력해보자.
        */

        int num1;
        num1 = 3;

        if (num1 % 3 == 0) {
            System.out.println("3의 배수입니다");
        }

    }
}
