package 칠번째_메서드;

//메서드 : 반복되서 사용되는 내용을 하나의 기능으로 정의.
//메서드 사용 : 메서드의 정의,메서드의 호출
//메서드의 정의 : 클래스 안, 다른 메서드의 밖에서 작성


public class Test11111 {
    public static void main(String[] args) {
        System.out.println("hello!");
        System.out.println("hello!");
        System.out.println("hello!");

        //메서드의 호출
        //정의한 메서드명과 일치+정의한 메서드의 매개변수 정보일치!
        //매개변수 정보 : 매개변수의 수(매개변수가 몇개냐?), 매개변수의 자료형 == 일치해야함
        sayHello();
        sayHello();
        sayHello();
        sayHello();

    }
    //메서드의 정의
    //접근제한자 리턴타입 메서드명(매개변수들){
    //      실행할 내용
    // }


    //자바에서 매소드는 소문자부터 시작
    public static void sayHello(){
        System.out.println("hi~");
    }

}
