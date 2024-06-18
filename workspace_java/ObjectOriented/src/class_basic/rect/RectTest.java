package class_basic.rect;

import javax.swing.plaf.PanelUI;

public class RectTest {
    public static void main(String[] args) {

        Rectangle r = new Rectangle(); // 0 0 0 0
        Rectangle s = new Rectangle(1,1,2,3);// 1 1 2 3

        r.show();
        s.show();
        System.out.println(s.square());
        r.set(-2,2,-1,4);
        r.show();
        System.out.println(s.square());

        if (r.equals(s)) {
            System.out.println("두 사각형의 넓이는 같습니다.");
        }









    }
}
