package 출력문;

public class Exam3 {
    public static void main(String[] args){
        // 문자열은 반드시 쌍따움("")에 감싸서 작성해야함! 꼮!
        System.out.println("안녕하세요~~");

        // 숫자는 쌍따움표("")에 감싸지 않는다!
        System.out.println(10);
        System.out.println("10"); // 이렇게 보여도 인식하는게 다름, 숫자 10보다는 문자 10으로 이해함( +더하기 안댐 )
        // s+out+enter >> 치면 바로나옴!!!!!
        System.out.println(10 + 10);
        //소괄호 안의 내용이 연산 가능하면 연산 결과 출력
        System.out.println("10 + 10"); // 문자 그대로 나옴
        System.out.println("java"+"hello");
        // 숫자와 문자의 합은 숫자를 문자로 간주하고 나열!
        System.out.println(10+"java");
        System.out.println(10+20+"java");
        System.out.println(10+"java"+20);
        System.out.println(5+"java"+5*10);


        System.out.println(10 > 5); // 10이 5보다 크다는 뜻 그래서 true  진실이라고 나오는거임 뭐야...
        System.out.println(10 < 5);

        //1과 1이 같습니까?
        System.out.println( 1 == 1); // 같다는 의미는 == 써야함
        System.out.println( 1 != 1); // 같지않다 or 다르다는 의미는 != 써야함

        // 아이고 어렵다 자바야~~~~~~~~정신나갈것같애ㅐ애ㅐ애ㅐ~~~~
    }
}
