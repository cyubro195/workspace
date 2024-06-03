package 네번째_조건문;

/*
    switch case break < 3가지가 다 들어와야함!
    switch(변수){ if문이랑 문법 똑같음!
       case 값1 :
       case 값2 :
       case 값3 :
    }
*/
public class Case_1 {
    public static void main(String[] args) {
        System.out.println("시작~");

        int num = 10;

        switch (num){
        // num이 ??일때 뭐하세요~
            case 1 : // num 값이 1일때 실행내용 , num 값에 맞춰서 시작점
                System.out.println(1);
                break; // 모든 case의 마지막 부분에 넣어주기!
            case 3 :
                System.out.println(3);
                break; // break 문을 만나면 switch 문 종료, swithch 와 break 는 항상 세트!
            case 5 :
                System.out.println(5);
                System.out.println(5);
                break;
            case 7 :
                System.out.println(7);
                break;
                // 마지막 case문에는 break를 안씀! 써도 상관없는데 보통은 안햠!

            default: // 그 밖에는, 조건이 맞지않으면~~
                System.out.println("해당 없음");

        }
        System.out.println("종료~");
    }
}
