package 여섯째_배열.문제;

//정수를 5개 저장할 수 있는 배열을 만들고,
// scanner를 통해 입력받은 값을 하나씩 배열의 요소에 저장해보자.
// 만약 키보드로 1 2 3 4 5를 입력했다면 배열의 요소에
// 각각 1 2 3 4 5 가 저장되어야 한다. 출력을 통해 결과를 확인

import java.util.Scanner;

public class Test_7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] number = new int[5];

        // 배열의 크기만큼 반복해서 입력값을 배열의 각 요소에 저장
        for(int i = 0; i < number.length; i++){
            System.out.print(i + " 번째 요소 입력 : ");
            number[i] = sc.nextInt();
        }
        System.out.println(" -배열에 저장된 요소-");
        for(int i = 0; i < number.length; i++){
            System.out.println(number[i] + " 0");
        }


        System.out.println();
        // for each 문으로 변형
        for(int e : number){
            System.out.print(e + " ");
        }





    }
}
