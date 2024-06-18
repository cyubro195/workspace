package class_basic.mem;

public class Div {
    private int a;
    private int b;

    public void setValue(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int calculate(){
        return a / b;
    }// 문제에서 int로 요구하는 상황이라 실수로 바꿀필요없음!
}
