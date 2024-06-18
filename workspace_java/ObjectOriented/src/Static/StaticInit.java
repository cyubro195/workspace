package Static;

//static 키워드가 붙은 멤버변수의 초기화 방법
//static 키워드가 붙은 멤버변수는 생성자에서 초기화 X
//초기화 구문이 따로 존재함!
public class StaticInit {
    int a;
    static int num; //공용변수가 됨

    //Static 변수 초기화
    static {
        num = 5;
    }

    public StaticInit(){
        a = 10;
        //num = 5; 생성자에서 Static 초기화 하지마셈!
        num++;

        System.out.println("a : " + a);
        System.out.println("num : " + num);


    }
}
