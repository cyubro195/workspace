package Interface;


/*


Wrapper class : 기본 자료형을 클래스로 표현한 것.
int - > Integer
double -> Double
boolean -> Boolean
float -> Float

*/
public class BoxTest {
    public static void main(String[] args) {
        //정수 10을 클래스화
        Integer a = Integer.valueOf(10);
        Integer c = 10;
        int d = 10;

        Box b = new Box();
        b.setBox(a); // 10 -> Integer
        //기본 자료형은 못들어가!!@!, 클래스만 다 들어간댜곩!




    }
}
