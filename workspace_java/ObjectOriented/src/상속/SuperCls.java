package 상속;

import java.nio.channels.Pipe;
import java.security.PublicKey;

public class SuperCls {

    //public SuperCls(){}
    public SuperCls(int a){

    }
    public SuperCls(String a, int b){

    }
}

class SubCls extends SuperCls{
    public SubCls(){
        super("aa",10); // 매개변수로 호출..
        System.out.println(111);
    }

}
