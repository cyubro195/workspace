package If_문제풀기_1;

public class Test_3 {
    public static void main(String[] args) {
        /*
        정수형 변수 a, b를 선언하고 각각을 임의의 정수로 초기화하자.
        그 후 a의 값이 크다면 ‘a가 큽니다.’를, b의 값이 크면 ‘b가 큽니다’를,두 변수의 값이 같다면 ‘같습니다.’를
        */

        int a =5;
        int b =2;

        if (a > b) {
            System.out.println("a가 큽니다");
        }
        else if (a < b) {
            System.out.println("b가 큽니다");

        }
        else {
            System.out.println("같습니다");

        }
    }
}
