package class_basic.calculator;

// 계산기 클래스....
public class Calculator {

    //변수 선언
    private int num1;
    private int num2;

    //num1, num2값을 변경하는 메서드
    public void setNumber(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    //더하기,빼기,나눗셈,곱셈 기능넣깃!

    //더하기 결과 리턴
    public int getSum(){
        return num1 + num2;
    }
    //빼기 결과 리턴
    public int getSub(){
        return num1 - num2;
    }
    //곱함 결과 리턴
    public int getMulti(){
        return num1 * num2;
    }

    //나눗셈 결과 리턴
    public double getDiv(){
        return num1 / (double)num2;
    } // 나누기는 정수보다는 실수로!



}
