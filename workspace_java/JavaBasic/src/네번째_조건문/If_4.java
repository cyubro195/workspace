package 네번째_조건문;

public class If_4 {
    public static void main(String[] args) {

        int x1 = 5;

        /*// 첫번째 예시
        // 만약에 x1(5)가 3보다 크니?
        if (x1 > 3) {
            System.out.println(1);
        }
        // 만약에 x1(5)가 5랑 같니?
        if (x1 == 5) {
            System.out.println(2);
        }
        // 만약에 x1(5)가 10보다 작니?
        if (x1 < 10) {
            System.out.println(3);
        }*/

        // 두번째 예시
        // 실행이 안되는 이유는 if는 참인데 else if는 부정이라서 안나오는거임!!!!!!
        if (x1 > 3) {
            System.out.println(1);
        }
       //그렇지 않으면
        else if (x1 == 5) {
            System.out.println(2);
        }

        else if (x1 < 10) {
            System.out.println(3);
        }




    }
}
