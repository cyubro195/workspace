package 네번째_조건문;

import java.util.Scanner;

public class test_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("첫 번째수 : ");
        int num1 = sc.nextInt();
        System.out.println("두 번째수 : ");
        int num2 = sc.nextInt();
        System.out.println("연산자 : ");
        String oper = sc.next();



        if (oper.equals("+")) {
            System.out.println(num1+"+"+num2 + "=" + (num1+num2));
            // 이렇게도 가능함
            // System.out.println(num1 + oper(연산자로 넣은거로 됨) + num2 + " = " + (num1 + num2));
        }
        else if (oper.equals("*")) {
            System.out.println(num1+"*"+num2 + "=" + (num1*num2));
        }
        else if (oper.equals("/")) {
            System.out.println(num1 + oper + num2 + " = " + (num1/ (double)num2)); //나누기라서 하나를 실수 바꿔줘야함
        }
        else if (oper.equals("-")) {
            System.out.println(num1 + oper + num2 + " = " + (num1-num2));
        }
        else {
            System.out.println("연산자를 잘못입력하였습니다.");
        }
    }
}
