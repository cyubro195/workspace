package 여섯째_배열.문제;

// 댕~~~~어려운 문제에ㅔ에~~~

//간단한 성적처리 시스템을 만들어보자.
//국어, 영어, 수학점수를 입력받아 각 과목에 대한 점수 및 총점,
//평균을 출력하는 프로그램을 만들어보자.
//반드시 배열을 사용하도록 한다.

import java.util.Scanner;
/*
public class Test_14_ {
    public static void main(String[] args) {

        //변수선언
        Scanner sc = new Scanner(System.in);
        // 0:국어, 1:영어, 2:수학, 3:총점
        int[] scores = new int[6];
        //과목명을 저장할 공간만들기
        String[] subjects = {"국어", "영어", "수학","사회","과학"};



        //평균만들기
        double avg;

        // 점수입력하기(0~100점 입력까지 무한입력) : 무한루프
                         // 과목수만큼 빼준다는?
        for(int i = 0; i < scores.length - 1; i++){

            while(true) {
                System.out.print( subjects[i] + "점수 : ");
                scores[i] = sc.nextInt();

                if (scores[i] >= 0 && scores[i] <= 100) {
                    break;
                } // 국어점수가 0~100점 사이 입력하고 무한루프 멈추게하는 법
            }
        }
        // 총점 및 평균 계산하기
        // 과목 3 -> score[0~3] > 0,1,2, + 3(총점)
        for(int i = 0; i < scores.length - 1; i++){
            scores[scores.length - 1] = scores[scores.length -1]+scores[i];
        }
        //그래서 평균은???
        avg = scores[scores.length - 1] / (double)(scores.length - 1);

        // 점수 및 총점 평균 출력
        System.out.println();
        System.out.println("----- 입력한 정보입니다 -----");

        // 과목에 대한
        for(int i = 0; i < scores.length; i++){
            System.out.println(subjects[i] + " 점수 - " + scores[i]);
        }
        System.out.println(" 총점 - " + scores[scores.length - 1]);
        System.out.println(" 평균 - " + avg);

    }
}*/
