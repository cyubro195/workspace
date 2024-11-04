public class LambdaPracticeTest {
    public static void main(String[] args) {
        // 람다르 이용해서 LambdaPracticeTest 인터페이서 안의
        // printName 메서드의 기능을 "홍길동입니다"가 출력될 수 있또록 구현하고, 호출하여 확인해보세요.
        // 매개변수가 없으면 매개변수 자리의 소괄호 생략 불가!
        LambdaPractice p = () -> System.out.println("홍길동데쓰");
        p.printName();

        //매개변수의 자료형은 생략, 매개변수명은 원하는대로!!
        //매개변수가 하나라면 매개변수 자료의 소괄호 생략가능!
                            // ▽ 변수명은 아무건 넣어도 상관없음
        LambdaPractice1 p1 = name -> System.out.println(name);
        p1.printName("홍길동");

        LambdaPractice2 P2 = (a,b) -> {
            System.out.println("이름 = " + a);
            System.out.println("나이 = " + b);
        };
        P2.printMyInfo("홍길동",20);

        LambdaPractice3 p3 = () -> 3;
            // 리턴타입이 있는 람다식은 {} 생략 불가!
            // 중괄호를 생략하려면 'return' 키워드고 같이 생략.
            //return 3; 숫자 하나만 있으니까 리턴하면 끝. 중괄호 생략하면 앙됨
            // 그냥 할려면 리턴 지우면됨 !
        System.out.println(p3.getData());


        LambdaPractice4 p4 = (num1,num2) -> num1+num2;
        p4.getResult(3,5);

        LambdaPractice5<Integer> p5 = (aaa,bbb) -> aaa + bbb;
        // 매개변수로 들어온 값을 리턴하겠다는 뜻.
        p5.getResult(10,20); // 30나오냐?

        // 제네릭은 내맘대로~~~
        LambdaPractice5<String> p6 = (a,b) -> a+b;
        p6.getResult("aa","bb");

        LambdaPractice6<String, Integer> p7 = (str1, str2) -> str2.length();
        p7.getResult("aa", "bbb");

    }
}
