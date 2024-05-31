package 변수와자료형;

public class 변수_1 {

    // main + enter = 치면 바로 나옴!
    public static void main(String[] args) {
        // 변수 - 값을 저장할 수 있는 공간
        // 변수를 사용하기 위해서는 먼저 변수를 선언해야 함! < 무조건
        // 변수 선언 문법 : 자료형(Data Type) 변수명;

        int num; // 정수를 저장하는 공간 num 선언
        // '=' (파이썬,자바 다 똑같이) 우측의 값을 왼쪽에 저장한다(대입,할당) *매우중요!
        num = 5;
        // num = 1.5; < 애는 오류!

        System.out.println("num"); // ("")>넣으면 문자로 인식해서 그대로 나옴
        System.out.println(num); // 5가 나온 이유는 num=5를 넣었기 때문에 코드가 제대로 입력된거임 ㅇㅇ...

        System.out.println("num = " + num); // num = 5

        num =10;
        // 하나의 변수에서는 하나의 값만 저장가능
        // 가장 최근에 대입한 값만 저장

        System.out.println("num = " + num); // num = 10이유는 위에 저거 하나만 기억함
    }
}
