package If_문제풀기_1;

public class Test_5 {
    public static void main(String[] args) {
        /*
        정수형 변수 하나를 선언하고 0 ~ 100까지의(0,100 포함) 숫자 중 임의의 값으로 초기화하자.
        그 후 변수의 값이 90보다 크고 100보다 작거나 같으면 ‘학점은 A입니다.’를 출력하고,
        80보다 크고 90보다 작거나 같으면 ‘학점은 B입니다.’를 출력하고,
        80점 이하라면 ‘학점은 C입니다.’를 출력해보자.
        */

        int num = 95;
        String grade;

        if (num > 90 && num <=100) {
            grade = "A 입니다";
        }
        else if (num > 80) {
            grade = "B 입니다";
        }
        else {
            grade = "C 입니다";
        }

        System.out.println("학점은 " + grade);

}

}
