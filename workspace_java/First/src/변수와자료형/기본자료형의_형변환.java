package 변수와자료형;

public class 기본자료형의_형변환 {
    public static void main(String[] args) {

        //정수는 실수에 저장 가능
        //자동 형변환(promotion)
        int num1 = 5;
        double num2 = num1;
        System.out.println("num2 = " + num2);


        //강제 형변환(Casting)
        double num3 = 5.5;
        // int num4 = num3; > 이렇게는 안된다요 오류오류! 저장 불가능!
        int num4 = (int)num3; // 실수 데이터 num3를 int로 강제 형 변화...
        System.out.println("num4 = "+ num4);
    }
}
