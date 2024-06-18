package Interface.math;

public class MyArrayUtil implements Interface.array.MyArrayUtil {

    @Override
    public double getTwoArrayAvg(int[] arr1, int[] arr2) {
        //매개변수를 받은 두 배열의 모든 요소의 평균을 리턴...
        // 쌤 답
        //arr1 = {1,2,3,4,5}
        //arr2 = {6,7,8,9,10}
        int sum1 = 0; // arr1배열의 합
        int sum2 = 0; // arr2배열의 합

        //arr1 배열의 합
        for (int i = 0; i <arr1.length; i++){
            sum1 = sum1 + arr1[i];
        }

        //arr2 배열의 합
        for (int i = 0; i <arr2.length; i++){
            sum2 = sum2 + arr2[i];
        }

        return (sum1 + sum2)/(double)(arr1.length + arr2.length); //평균값구하기

        /*
        지피티답
        double sum = 0;
        int total = arr1.length + arr2.length;

        for (int num : arr1) {
            sum += num;
        }
        for (int num : arr2) {
            sum += num;
        }

        return sum / total;
        */
    }

    @Override

    //매개변수로 받은 배열의 모든 요소가 짝수일때만 리턴 trun.
    //array = {1,2,4,6,7=8}

    public boolean isEvenArray(int[] array) {

        //for-each문쓰기
        for (int e : array){
            if (e % 2 == 1) {
                return false;
            }
        }
        return true;

    }
}
