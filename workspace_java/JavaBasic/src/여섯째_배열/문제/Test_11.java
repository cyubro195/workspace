package 여섯째_배열.문제;
// 문제 2-6

//1,2,3을 초기값으로 갖는 배열 arr1과 4,5,6을 초기값으로 갖는 arr2를 만든다.
// 그 후 새로운 배열 newArr을 만들어 arr1과 arr2의 모든 값을 복사해보자.
// 복사 후 newArr은 1,2,3,4,5,6을 가져야 한다.

public class Test_11 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};

        // 워라벨 절대 지켜어ㅓ어거ㅓ어!

        int[] newArr = new int[arr1.length + arr2.length];

        for(int i = 0; i < arr1.length; i++){
            newArr[i] = arr1[i];
        }

        for(int i = 0; i < arr2.length; i++){
            newArr[arr1.length + i ] = arr2[i];
            // newArr 안에 이미 앞에 3개가 들어갔으므로 i는 안됨!
        }
        for(int e : newArr){
            System.out.print(e + " ");
        }

    }
}
