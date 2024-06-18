package Static;

// 초기화 테스트
public class InitTest {


    public static void main(String[] args) {

        StaticInit i1 = new StaticInit();
        StaticInit i2 = new StaticInit();
        StaticInit i3 = new StaticInit();
        //num값 5에서 num++했기때문에 +1 되서 6이 나온는거!

        //static 변수를 읽고 사용하는 방법
        //객체명.변수명으로 static 변수도 사용가능.[추천하진않음]
        System.out.println(i1.num);
        System.out.println(i2.num);

        //static 변수 및 메서드는 클래스명.변수명으로 접근
        System.out.println(StaticInit.num);//< 이게 맞음!

        /////////////////////
        System.out.println("10.5");

    }
}
