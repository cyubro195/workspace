package Interface.array;

import Interface.math.MathUtil;

public class MyMath implements MathUtil {


    @Override
    public int getMin(int a, int b) {
        int ee;

        if (a > b) {
            ee = b;
        }
        else {
            ee = a;
        }
        return ee;

        // a < b ? a : b;
    }

    @Override
    public double getCircleArea(int radius) {
       /*
       if (radius < 0) {
            return 0; // 반지름이 음수인 경우 0을 반환합니다.
        } else {
            return 2 * Math.PI * radius; // 반지름을 사용하여 원의 둘레를 계산합니다.
        }
        */
        return radius < 0 ? 0 : 2 * Math.PI * radius; // 깔끔한 답..
    }

    @Override
    public int getMultiple(int num1, int n) {
        int result = 1; // 0으로주면 계속 0나옴
        for(int i = 0; i < n ; i++){
            result = result * num1;
        }

        return 0;
    }
}
