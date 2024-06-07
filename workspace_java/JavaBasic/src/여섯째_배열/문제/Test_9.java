package 여섯째_배열.문제;

import java.util.Scanner;

// scanner로 정수 하나를 입력받아,
// 입력받은 정수만큼의 길이를 갖는 배열을 생성하고
// 배열에 각 요소에 1 ~ 입력 받은 정수로 값을 저장한다.
// 예를 들어 5를 입력했으면 길이가 5인 배열을 만들고
// 각 요소에 1,2,3,4,5가 들어가야 한다.
// 그 후 배열에 들어간 수의 평균을 출력해보자.
public class Test_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("배열의 크기 : ");
        int length = sc.nextInt();

        int[] arr = new int[length];
        //배열할때 for문은 거의 짝지!!!

        for(int i = 0; i < arr.length; i++){
            arr[i] = i + 1; // i에 1씩 증가
        }
        // 합을 구하깅 위행서능?
        int sum = 0;
        // 일반식 or foreach문
        for(int e : arr){
            sum = sum + e;
        }
        //평균 구하기
        System.out.println(sum / (double)arr.length);
    }
}
