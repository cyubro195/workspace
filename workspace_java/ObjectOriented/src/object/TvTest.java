package object;

import 상속.MobilePhone;

public class TvTest {
    public static void main(String[] args) {
        Tv tv = new Tv();

        //객체명,변수명   객체명,메서드명으로 변수와 메서드 호출가능!
        System.out.println(tv.modelName);
        tv.powerOn();

        //object 클래스는 모든 클래스의 부모클래스다.
        //자료형이 다르면 데이터 저장 불가
        //다형성에 의해서 부모클래스로 자식클래스 객체를 저장 할 수 있다.
        Object o1 = new Tv(); // Object : 오브젝트 클래스
        Object o2 = new MobilePhone();
        // 전혀 상관없는 클래스라도 object 클래스에 다 들어감!(모든 부모라서 다 들어감)
        // 단, 부모클래스꺼만 쓸 수 있어서 원래 기능을 못씀! 그래서 제한적으로 쓰는경우가 많음!



    }
}

