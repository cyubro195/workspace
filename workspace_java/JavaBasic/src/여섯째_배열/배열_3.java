package 여섯째_배열;

public class 배열_3 {
    public static void main(String[] args) {
        // 정수를 5개 저장할 수 있는 배열 arr1을 생성
        int[] arr1 = new int[5]; // 0 0 0 0 0 > 생성됨
        System.out.println(arr1); // 이상한 값 나옴ㅎ

        // 배열에 저장된 값을 출력할 때는 배열의 요소로 접근한다.
        System.out.println(arr1[0]); // arr1의 0번째 요소를 출력한다는 뜼>!<
        // System.out.println(arr1[5]); > 주의!!! 0~4번째가 최대임 5번째없음

        //arr1의 0~4번째 요소까지의 모든 값을 출력
        // 배열은..반복문이랑 아주 찰떡궁합
        /*
        for(int i = 0; i <5; i++){
            System.out.print(arr1[i]);
        }
        System.out.println();
        */

        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i]);
        }
        System.out.println();


        //배열의 크기
        int[] arr2 = new int[2];
        int[] arr3 = new int[5];
        int[] arr4 = new int[10];

        System.out.println(arr4.length);
        // 배열명.length 를 사용하면 배열 크기를 출력 할 수 잇댜




    }
}
