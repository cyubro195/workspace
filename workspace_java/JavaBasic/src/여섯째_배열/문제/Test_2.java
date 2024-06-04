package 여섯째_배열.문제;


// 정수를 5개 저장할 수 있는 배열을 생성하고
// 배열의 2번째, 4번째 요소의 값을 출력해보아라.

public class Test_2 {
    public static void main(String[] args) {

        int[] arr1 = new int[5]; // 00000
        arr1[2] = 10;
        arr1[4] = 5;

        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i]);
        }

    }
}


