
// 선수 학습
// 이너 클래스(inner class) : 클래스 안에 선언된 클래스를 뜻함.
// 클래스의 멤버(구성요소) : 멤버변수(필드), 메서드, 생성자, 클래스
/*
 [ 이너 클래스의 종류 ]
1. 멤버 이너 클래스 : 멤버변수의 선언 위치와 같은 위치에 만들어진 이너 클래스
2. 로컬 이너 클래스 : 지역변수의 선언 위치와 같은 위치에 만들어진 이너 클래스
3. 익명 이너 클래스(람다의 출발지점)
 */

public class Outer {
    private int num;

    //변수라는 생성자 호출
    public Outer(){
        this.num = 0;
    }

    // 또 다른 클래스를 만들수있음 오류안남
    // 멤버 이너 클래스
    class Board{
        public void printNum(){
            System.out.println("num = " + num);
        }
    }

    //메서드
    public void aaa(){
        int age = 0; //지역변수
        //로컬 이너 클래스
        class Item {
            public  void printAge(){
                System.out.println("age= " + age);
            }
        }
    }

}
