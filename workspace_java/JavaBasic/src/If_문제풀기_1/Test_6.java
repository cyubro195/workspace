package If_문제풀기_1;

public class Test_6 {
    public static void main(String[] args) {
        /*
        정수형 변수 하나를 선언하고 임의의 숫자로 초기화하자.
        그 후, 입력한 숫자가 5의 배수가 아닐 경우에만
        ‘5의 배수를 입력하세요.’라고 출력되게 프로그램을 만드시오.
        */

        int num;
        num = 34;

        if (num % 5 != 0) {
            System.out.println("5의 배수를 입력하세요.");
        }
    }
}
