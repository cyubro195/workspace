package 상속;

import java.nio.channels.Pipe;

class A1{
    private int x;
    private int y;

    public A1(){
        x = 1;
        y = 1;
    }
    public A1(int x){
        this.x = x;
        y = 1;
    }
    public A1(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void disp(){
        System.out.print("x = " + x + " , y = " + y);
    }

}
class B1 extends A1{
    private int x; //코드를 아무것도 않넣을때는 무조건 0
    private int y; //0

    public B1(){ //부모클래스, super 숨어있뜸.
        x = 1;
        y = 1;
    }
    public B1(int x){ //10
        super(x);
        this.x = 1;
        y = 1;
    }

    public B1(int x, int y){
        super(x,y); //부모클래스에서 받아온걸 넣어주기!
        this.x = 1;
        this.y = 1;
        //이름이 매개변수랑 같기 때문에 정확하게 들어가기 위해서는 this를 써야함
    }

    public void disp(){
        super.disp();
        System.out.print("x = " + x + " , y = " + y );
    }
}

public class Work {
    public static void main(String[] args) {
     B1 bp = new B1();
     B1 bp1 = new B1(10);
     B1 bp2 = new B1(10,20);
//     B1 bp3 = new B1(10,20,30);
//     B1 bp4 = new B1(10,20,30,40);

                //부모클래스         자식클래스
     bp.disp(); // x = 1 , y = 1 , x = 1 , y = 1
     bp1.disp();// x=10,y=1, x = 1 , y = 1
     bp2.disp();// x=10,y=20, x = 1 , y = 1
//     bp3.disp();// x=10,y=20, x = 30 , y = 1
//     bp4.disp();// x = 10, y = 20 , x = 30, y = 40



    }
}
