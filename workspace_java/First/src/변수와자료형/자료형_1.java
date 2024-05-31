package 변수와자료형;

//**자료형이 다르면 데이터 저!장!불!가!!!! 기억하세요! **

// 자바는 크게 기본 [자료형]과 [참조 자료형]으로 데이터의 형태를 구분
// 자바에서 기본 자료형은 총 8개.
// 참조 자료형은 무한대. < 이해 안되는게 정상!

// 정수자료형은 int가 기본, 실수 자료형은 double이 기본!
// 기본 자료형 - 중요하니까 외우세용!
/*
    정수타입 : byte, short, int, long
    실수타입 : float, double
    논리타입 : boolean
    문자타입 : char
*/

// 문자열 타입 : String!!!!!! 기본 자료형 절대 아님!!!!!**매우 중요*** (참조 자료형임)
// 차이는 기본자료형은 소문자로 되어있지만, 참조 자료형은 앞글자가 대!문!자!

public class 자료형_1 {
    public static void main(String[] args) {
        byte n1 = 100; //선언과 동시에 가능함
        // byte n2 = 1000; byte 범위 초과로 오류뜸!

        int n2 =100;
        // int n4 = 10.5;

        double n3 = 10.5; //실수가 가능함! int에는 안됨

        // 주의사항 : 쌍따옴표 없음!! > boolean b1 = "true"; x 안됨, 왜냐 ("")넣으면 문자로 인식함!!@!!
        boolean b1 = true;
        boolean b2 = false;

        //문자열 (0개 글자 이상 + ("")쌍따옴표로 감싸줘야함!)
        String s1 = "java";
        String s2 = "false"; // < 이렇게 넣으면 거짓이라는 의미가 아니고 문자로 들어가게 됨~!
        // String s2 = false; // < 근데 애는 이거 안됨. 자료형만 됨!! **진짜 중요** 자료형만 데이터 들어감!

        //문자(한 글자 + ('')홀따옴표로 감싸줘야함!)
        char c1 = 'j';
        System.out.println("c1 = " + c1);
        char c2 = 65; // 숫자는 들어감
        System.out.println("c2 = " + c2);
        // char c1 = "java"; > 문자열에만 들어가는거임! 문자에는 들어가지 않음!!!

        char c3 = 'A';
        int c4 = c3;

        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);

        String aaa = "A";
    }
}
