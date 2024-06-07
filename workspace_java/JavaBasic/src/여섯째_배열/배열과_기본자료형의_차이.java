package 여섯째_배열;

// 사실 잘 몰라도 괜찮은데 이해는 바람.ㅎ
public class 배열과_기본자료형의_차이 {
    public static void main(String[] args) {
       /*

        가장 기본적으로 배운식...
        int a1 = 10;
        int b1 = a;

        a1 = 20;
        System.out.println("a1 = " + a1);
        System.out.println("b1 = " + b1);

        */

        //위에꺼랑 똑같은 답...유형
        int[] a = {1,3,5};
        int[] b = a;
        a[0] = 10; // a값을 1에서 10으로 바꿈!
        b[2] = 50;

        for(int e : a){
            System.out.print(e + " ") ;
        }
        System.out.println();
        for(int e : b){
            System.out.print(e + " ");
        }


        //배열의 복사
        int[] c = {1,2,3};
        int[] d = c.clone();







    }
}
