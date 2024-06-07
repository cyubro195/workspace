package 여섯째_배열.문제;
// 문제 2-8

import java.util.Arrays;

//간단한 로또번호 생성기를 만들어보자.
//길이가 6인 정수형 배열을 생성하고,
//배열의 모든 요소에 1에서 45까지의 랜덤한 정수를 넣어보자.
//그리고 배열의 모든 요소를 출력해보자.(1과 45를 포함하고,중복값은 허용한다.
public class Test_12 {
    public static void main(String[] args) {

    // 간단한 로또번호 생성기 만들기!
        int[] lotto = new int[6];

        for(int i = 0; i < lotto.length; i++){
            lotto[i] = (int)(Math.random() * 45 + 1);
        }
        // 간단하게 출력 하는 방법??
        System.out.println(Arrays.toString(lotto));


        // 1.0 <= x < 46.0 실수! > 왜냑 45.999가 나옴
        // int r = (int)(Math.random() * 45 + 1);
        // System.out.println(r); >  1~45 숫자 랜덤으로 나옴!











    }
}
