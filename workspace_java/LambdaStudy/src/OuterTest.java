public class OuterTest {
    public static void main(String[] args) {

        //Outer 클래스에 대한 객체 생성을 먼저 해줘야햠!
        Outer outer = new Outer(); //객체생성

        //Board 클래스의 객체 생성
        Outer.Board b = outer.new Board();
        b.printNum(); // 요즘엔 안햐

        //예기치 않은 코드 작성의 위험성 존재

    }


}
