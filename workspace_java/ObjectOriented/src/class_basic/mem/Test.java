package class_basic.mem;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("- 실행예시 -");
        System.out.println("첫번째 수 : ");
        int a = sc.nextInt();
        System.out.println("두번째 수 : ");
        int b = sc.nextInt();
        System.out.println("연산자 : ");
        String oper = sc.next();

        // swich case로 풀기

        switch(oper){
            case "+" :
                Add add = new Add();
                add.setValue(a,b); //키보드로부터 입력받을 정수를 의미함
                // 10 + 20 = 30
                System.out.println(a + "+" + b + "=" + add.calculate());
                break;

            case "-" :
                Sub sub = new Sub();
                sub.setValue(a,b); //키보드로부터 입력받을 정수를 의미함
                // 10 - 20 = 30
                System.out.println(a + "-" + b + "=" + sub.calculate());
                break;

            case "*" :
                Mul mul = new Mul();
                mul.setValue(a,b); //키보드로부터 입력받을 정수를 의미함
                // 10 * 20 =
                System.out.println(a + "*" + b + "=" + mul.calculate());
                break;

            case "/" :
                Div div = new Div();
                div.setValue(a,b); //키보드로부터 입력받을 정수를 의미함
                // 10 / 20 = 30
                System.out.println(a + "/" + b + "=" + div.calculate());
                break;

            default : // 나머지 else 랑 같음
                System.out.println("연산자를 잘못입력하였습니다");

        }






    }
}
