package object;

//클래스가 상속을 받고 있지 않다면, 자동으로 Object 클래스를 상속받음.
//모든 클래스는 object 클래스를 상속 받는다.

import class_basic.Monitor;

public class Tv extends Object{
    String modelName;

    public void powerOn(){
        System.out.println(" 전원을 켭니다! ");
        aaa(5);

        //문법을 맞춤........뭐라는지 모르겟댜...
        Monitor mm = new Monitor();
        bbb(mm);

        ccc(mm); // 1,문자열,위에 mm 해도 오류가 안남(뭘해도 오류안남)

    }
    public void ccc(Object obj){

    }

    public void bbb(Monitor m){

    }
    public void aaa(int a){ // int a = 10

    }
}

class LgTv extends Tv{ //lgtv가 tv에 상속된거임!

}