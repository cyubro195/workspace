package 상속;

public class PhoneTest {
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone(); // 객체생성
        SmartPhone sp1 = new SmartPhone();

        //부모클래스로는 자식 클래스의 객체를 받을 수 있음.
        //다형성으로 생성된 객체는 부모클래스의 변수, 메서드만 사용가능!!
        // 왼쪽 부모        오른쪽 자식
        MobilePhone m2 = new SmartPhone(); // 상속관계ㅣ스파트폰 속성임!
        // m2.playApp(); 오류발생!
        m2.sendMsg();

      //SmartPhone sp2 = new MobilePhone(); 오류! 자식은 부모를 받을 수 없음.



    }
}
