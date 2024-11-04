import java.util.Scanner;

public class Array_3 {



    //1. 정수를 3개 저장할 수 있는 배열

    /*
        int[] arr1 = new int[3];
        double[] arr2 = new double[5];
        String[] arr3 = new String[10];
        int[] arr4 = {1,5,10};
        String[] arr5 = {"자바","C언어","파이선"};
    */

    //2. 정수를 5개 저장할 수 있는 배열을 생성하고 배열의 2번째, 4번째 요소의 값을 출력.

    /*public static void main(String[] args) {
        int[] arr1 = new int[5];
        arr1[2] = 10;
        arr1[4] = 12;

        for (int i = 0 ; i < arr1.length; i++){
            System.out.print(arr1[i]);
        }
    }*/

    //3. 정수를 10개 저장할 수 있는 배열을 생성하고 모든 요소의 값을 출력해보아라.
    /*
        public static void main(String[] args) {
        int[] arr2 = new int[10];

        for (int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i]);
        }
    }*/

    //4. 정수를 10개 저장할 수 있는 배열을 생성하고 모든 요소에 3을 넣고,
    //   그리고 3이 잘 들어갔는지 출력하여 확인해보아라.
    /*
        public static void main(String[] args) {
            int[] arr = new int[10];
            for (int i = 0; i < arr.length; i++){
                arr[i] = 3;
                System.out.println(arr[i]);
            }
        }
     */

    //5. 정수 10개 배열생성, 각 요소 1~10까지 넣으셈!
/*

    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1; // 기본값에서 증가해야하는 값을 더해야하기 때문에 +1를 붙어줙락!
            System.out.print(arr[i]);
        }
    }
*/

    //6. 1,5,7을 초기값으로 저장하고 있는 배열을 만들고, 배열의 모든 요소의 합을 출력
/*

    public static void main(String[] args) {
        int[] arr1 = {1,5,7};
        int sum = 0;

        for (int i = 0; i < arr1.length; i++){
            sum = sum + arr1[i];
        }
        System.out.println(sum);
    }
*/

    //7. 정수를 5개 저장할 수 있는 배열을 만들고, scanner를 통해 입력받은 값을 하나씩 배열의 요소에 저장해보자
    // 만약 키보드로 1 2 3 4 5를 입력했다면 배열의 요소에 각각 1 2 3 4 5 가 저장되어야 한다
    // 출력을 통해 결과를 확인해 보아라.
/*

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr2 = new int[5];

        for (int i = 0; i< arr2.length; i++){
            System.out.print("숫자를 입력하소! >> ");
            arr2[i] = sc.nextInt();
        }
        System.out.print("입력된 값??? : ");
        for (int i = 0; i < arr2.length; i++){
            System.out.print(arr2[i]);
        }


    }
*/

    //8. 1, 2, 3, 4, 5, 6 ,7 ,8 로 초기화된 배열을 만들고,
    // 배열의 요소 중 짝수의 개수를 구하는 프로그램을 만들어라.

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6 ,7 ,8};
        System.out.println("짝수구하셈 ㅎ ");

        for (int i = 0; i < ){

        }
    }






}
