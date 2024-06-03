package 네번째_조건문;


// 기본자유형들
// byte, short, int, long
// float, double
// boolean
// char

public class 문자열비교 {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;

        System.out.println(x == y);  // 연산자

        String s1 = "java";
        String s2 = "python";

        //* 문자열 비교 시험에 나옴!
        System.out.println( s1 == s2 ); // 두개다 같은거에옹? 라는 문자열 비교가 아님!
        System.out.println("1" == "1"); // 문자열 비교가 아님!

        String name = "kim";
        // name 변수의 값이 "kim"이랑 같은가?
        // name.equals("kim"); // 결관는 참 또는 거짓밖에 안나옴

        boolean result = name.equals("kim");
        System.out.println(result);


        String addr = "울산";
        // if문
        if (addr.equals("울산")) { // 착각하지말기!

        }



    }
}
