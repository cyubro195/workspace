package 칠번째_메서드;

// 매개변수(parameters) : 메서드 정의 부분 소괄호 안에서 정의된 변수

public class 메서드_3 {
    public static void main(String[] args) { // < 매개변수
        tellYourName("자바");
        tellYourName("잠와유");
        tellYourName("매우 잠와유");

        // tellYourName(5); 매개변수의 자료형 일치 필요!
    }

    public static void tellYourName(String name){
        System.out.println("제 이름은 " + name);
    }
}
