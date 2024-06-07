package 칠번째_메서드.문제;

import javax.xml.transform.Result;
import java.nio.channels.Pipe;
import java.util.Arrays;

public class Test_3 {
    public static void main(String[] args) {
        // test1(2);
        // int[] a = {1,3,5};
        // test5(a); // 변수명은 상관하지마셈!
        // System.out.println(test3(20));
        //System.out.println(test4(5));
/*

        int[] arr = {1 ,7, 5, 3, 2};
        int max = test6(arr);
        System.out.println(max);
*/
        //test6();
        /*
        String[] ar = {"a"+"b"+"c"};
        String result = test7(ar);
        System.out.println(result);
        */
        int[] a = {1,2,3,4,5,6,7,8,9,10}
        int[] result = test9(a);


    }
    // 문제 9번  * 제일 어려운 문제

    public static void test9(int[] array){
        // 매개변수로 넘어온 배열 요소 중 짝수의 개수
        int cnt = 0;
        for(int e : array){
            if (e % 2 == 0) {
                cnt++;
            }
        }
        //짝수만 저장될 배열 생성
        int[] resultArr = new int[cnt];

        int index = 0;
        for( int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
            resultArr[index] = array[i]; // 0번째 요소를 넣어주세요
                index++;
            }
        }
        return result;
    }




    // 문제 7번

    public static String test7(String[] arr){
        String result = "";
        for(int i =0; i<arr.length; i++){
            result = result + arr[i];
        }
        return  result;
    }



    //문제 6번
    public static int test6(int[] array){ // 1 7 5 3 2
        int max = 0;
        for (int i = 0; i < array.length; i++){
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }



    //문제 5번 풀이
    public static void test5(int[] test) {//int[] test = a;
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }

    //4번 문제
    public static boolean test4(int num) {
        return num % 2 == 0;

    }

    //3번 문제
    public static int test3() {
        return (int) (Math.random() * 50 + 1);
    }

    //2번 문제
   /* public static int test3(int num) {
        int cnt = 0;
        for (int i = 1; i < 101; i++) {
            if (i % 3 == 0) {
                cnt++;
            }
        }
    }*/

    //1번 문제
    /*public static int test1(int num) {
        for (int i = 0; i < 10; i++) {
            System.out.println(num + "*" + i + "=" + (num * i));
        }
    }*/
}
