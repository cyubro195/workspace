package 칠번째_메서드;

public class 메서드_5 {
    public static void main(String[] args) {
      // 메서드 실행할 곳
       int result = getSum(50 , 60); // 메서드 등록하고!
       System.out.println(result); // 실행할려면 코드입력해야함!, 냅두면 안생김!
      // System.out.println(getSum(50, 60)); 짧게 출력하는 방법! 위 아래 둘 다 같!

       double result2 = getSum2(10, 20); // 리턴타입을 꼭 바꿔줘야함! 매우 중요

    }

    // 메서드 정의
    // 매개변수로 전달된 두 정수의 합을 리턴하는 메서드
    public static int getSum(int a, int b){ // > 잘 모를때는 int부분을 void 쓰고 시작해도 됨!
        return a + b; // 두 수의 합을 밖으로 던져주겠다는 뜻, 리턴쓸때는 정수면 정수 키워드 넣기

    }

    // 매개변수로 전달된 두 정수의 합을 실수형태로 리턴하는 메서드
    public static double getSum2(int a, int b){
        return a + (double)b;
    }

}
