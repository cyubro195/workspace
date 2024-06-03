package 변수와자료형;

public class 변수_4 {
    public static void main(String[] args) {
        // 1. 변수는 선언 후 반드시 최초 값을 한 번은 할당
        int num;
        num = 5; // 이 코드가 없어지면 오류 발생!
        System.out.println(num);

        //변수의 선언 및 값 할당은 동시에 가능!
        int a; //변수선언
        a = 7; //할당

        int b = 10;

        // 자료형이 같은 변수는 한 번에 여러개 선언 가능
        // int a1;
        // int b1;
        // int c1; > 이렇게 하나하나 안하고 int a1,b,c1; 도 가능 근데 왠만해선..쓰지마셈 ㅎ

        int a1,b1,c1;
        a1 = 10;
        b1 = 20;
        c1 = 30;

    }
}
