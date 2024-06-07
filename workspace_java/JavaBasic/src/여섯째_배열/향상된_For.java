package 여섯째_배열;

public class 향상된_For {
    public static void main(String[] args) {
    //for-each문 : 배열에서 값을 읽을 때 사용

    int[] arr1 = {1,3,5,7,10};
    for(int i = 0; i < arr1.length; i++){
        System.out.print(arr1[i]);
    }
    System.out.println();

    // arr1 ={1,3,5,7,10}
    // 왼쪽항 : 배열에서 데이터를 하나씩 차례로 뺏을 때 저장할 변수
    // 오른쪽항 : 반복할 배열
    for(int e : arr1){ // int e = 1;
        System.out.println(e);//맨 앞부터 반복출력!
    } //for-each 문.
        System.out.println();

    double[] arr2 = {1.1,2.2,3.3,4.4};
    for(double e : arr2){ //변수 선언이기 때문에 e자리에 마음대로 적어드댐
        System.out.println(e);

    }
        System.out.println();

    String[] arr3 = {"a","b","c","d"};
    for( String e : arr3){
        System.out.println(e);
    }






    }
}
