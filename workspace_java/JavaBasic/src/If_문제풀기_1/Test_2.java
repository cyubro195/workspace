package If_문제풀기_1;

public class Test_2 {
    public static void main(String[] args) {
        //정수형 변수 하나를 선언하고 임의의 정수로 초기화하자.
        //그 후, 만약 변수의 값이 짝수이면 ‘짝수입니다.’, 홀수이면 ‘홀수입니다.’를 출력해보자.

        int num1;
        num1 = 15;

        if (num1 % 2 == 0) {
            System.out.println("짝수입니다");
        } else if (num1 % 3 == 0) {
            System.out.println("홀수입니다");
        }
    }
}
