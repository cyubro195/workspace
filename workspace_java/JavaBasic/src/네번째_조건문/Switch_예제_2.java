package 네번째_조건문;


// 주민등록번호의 7번째 자리는 성별을 나타낸다.
// 7번째 자리의 수가 '1' 또는 '3'은 남자를 표현
// 7번째 자리의 수가 '2' 또는 '4'는 여자를 표현
// 키보드를 주민등록번호 7번째 입력을 받아 남자일 경우 '남성'으로 출력하고
// 여자일 경우 '여성'으로 출력받고 나머지 잘못된 숫자는 입력하면 '오류'라고 출력

import java.util.Scanner;

public class Switch_예제_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("주민등록번호 7번째 자리 입력 : ");
        int number = sc.nextInt();

        switch (number){
            case 1,3 :
                System.out.println("남성");
            break;

            case 2,4 :
                System.out.println("여성");
            break;

            default:
                System.out.println("오류!");
        }
    }
}
