package class_basic;

// [ 좋은 클래스의 여건 ]
// 1.멤버 변수는 반드시 초기값을 설정하는게 좋다!
// 2. 초기값 설정은 멤버변수의 선언과는 별도로 진행!

// 생성자 : 선언한 변수의 값을 초기화할 용도로 사용
// 문법
/*
 public 클래서명( ){ }

*/
// 클래스 안에는 반드시 생성자가 존재해야ㅏ함!!!
// 만약 클래스 안에 생성자를 하나도 선언하지 않았다면 눈에 보잊 ㅣ않는
// 기본 생성자를 자동으로 만들어 줌(내용도 없고, 매개변수도 없는 생성자)
// 생성자는 여러개 만들 수 있음.



import java.sql.SQLOutput;

public class Account {
    String accNumber; // = null; 이라도 적어주는게 좋음.
    String owner;
    int money; // 예금액

    public Account(){
        accNumber = "미정";
        owner = "미정";
        money = 1000;
    }

    public Account(int a){ //메소드 오버로딩으로 이용하면 중복이여도 겹치지 않고 실행할수있음!
        money = a;

    }

    // 모든 변수의 값을 초기화하는 메소드
    //잘 모를때는 클릭해보깃!
    public void setAccount(String accNumber, String owner,
                           int money) {
        //이 클래스에서 선언한 accNumber
        this.accNumber = accNumber;
        this.owner = owner;
        this.money = money;
    }

    public void printAccount(){
        System.out.println("계좌번호 : " + this.accNumber);
                                         //이렇게는 사용가능!
        System.out.println("계좌주 : " + owner);
        System.out.println("예금액 : " + money);
    }

}
