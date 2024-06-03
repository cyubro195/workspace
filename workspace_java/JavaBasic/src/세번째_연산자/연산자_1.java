package 세번째_연산자;

public class 연산자_1 {
    public static void main(String[] args) {
        // 산술 연산자 : +,-,*,/,%(나머지)
        // % mod 연산자
        System.out.println(10 / 4); //2
        System.out.println(10 % 4); //2
        System.out.println(10 % 3); //1 > 나머지만

        System.out.println(+10);
        System.out.println(-10);

        // 비교 연산자
        // == (같다라는 의미) , !=(같지않다)
        // >(크다) , >=(크거나 같다), <(작다),<=(작거나 같다)

        System.out.println(5 >= 3); //true

        // 논리 연산자(맞다(참), 틀리다(거짓))
        // x가 5보다 크고 10이하다 --> 5 > x <= 10
        // && 그리고, || 이거나
        // & 그러나 , | 이거나
        int x = 3;
        boolean r1 = x > 5 && x <= 10; // 자주 안쓰긴하지만 혹시나~~~~

    }
}
