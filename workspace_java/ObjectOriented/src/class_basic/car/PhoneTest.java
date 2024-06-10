package class_basic.car;

public class PhoneTest {
    public static void main(String[] args) {
        Phone p = new Phone();
       // System.out.println(p.price);

       // p.price = 1000;
        p.setPrice(1000);
        // 2가지 문법이 가능하나 이걸추천!
        // 변수값을 직접적으로 줘버리면 나중에 잘못된것을 막을수가없음!

        p.modelName = "aa";
        p.brand = "aa";




    }
}
