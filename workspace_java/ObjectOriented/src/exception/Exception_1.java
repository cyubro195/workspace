package exception;


import java.util.Scanner;

//예외처리
/*
    예외처리 문법
    try{
      예외가 발생할 수 있는 코드 작성
    }catch(Exception e){
      예외 발생 시 실행코드

     - Exception :
     - ArithmeticException : 수학적, 정수만 가능
     - InputMismatchException : 문자열 가능

    }finally{
      예외가 발생하든, 하지않던 무조건 실행할 코드
    }

*/
public class Exception_1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        try {

            System.out.println("첫번째 : ");
            int a =sc.nextInt();
            System.out.println("두번째 : ");
            int b =sc.nextInt();

            System.out.println(a/b);

        }catch(Exception e){ // Exception : 예외에 대한 정보가 들어있는 class.

            System.out.println(" 오류발생!! "); //예외(오류)가 발생해도 프로그램은 진행됨.
            System.out.println(e.getMessage()); //예외발생 이유를 간략히 문자열로 전달해줌.
            e.printStackTrace(); // 예외처리를 강제로 불러준(?)상황임



        }

        System.out.println("프로그램 종료");
    }
}
