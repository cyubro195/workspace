package class_basic.car;

public class CarTest {

    public static void main(String[] args) {

        Car c1 = new Car();

        // c1의 변수를 출력
        System.out.println(c1.brand);
        System.out.println(c1.modelName);
        System.out.println(c1.price);
        System.out.println(c1.carNumber);
        System.out.println(c1.owner);

        // c1 변수의 값 변경
        c1.brand = "porsche";
        c1.price = 14850;

        // c1의 변수를 출력
        System.out.println(c1.brand);
        System.out.println(c1.price);

        ///////

        Car c2 = new Car(); // 개체명은 중복이 안됨!
        c2.printCarInto(); // 자동완성으로 나옴 ㅎ
        c2.setBrand("기아");
        c2.setModelName("k3");
        c2.setCarNumber("1121");
        c2.setPrice(2000);

        // 전체호출
        c2.printCarInto();




    }
}
