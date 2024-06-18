package Interface.student;


import 상속.Grand;

import javax.naming.NamingEnumeration;

public class MyStudent implements StudentUtil{


    @Override
    public String getGradeByStudentName(Student[] students,String name) {

        String grade = "등급없음";
        //반복적으로 학생이름이 뭔지 물어야함..
        for (Student stu : students){
            if (stu.getName().equals(name)){
                double avg = (stu.getKorScore() + stu.getMathScore() + stu.getEngScore()) / 3.0;
                grade = getGradeByavg(avg);
            }
        }
        return grade;
    }


    // 짧게 줄여서 대답하기!
    // 점수에 따라 등급결정 만들기
    public String getGradeByavg(double avg){
        String grade = "등급없음";
        if( avg >= 90 && avg <= 100){
            grade = "A";
        }
        else if(avg >= 80){
            grade = "B";
        }
        else if(avg >= 70){
            grade = "C";
        }
        else {
            grade = "D";
        }
        return grade;
    }



    //매개변수로 받은 다수의 학생들의 총점을 배열로 리턴
    @Override
    public int[] getTotalScoresToArray(Student[] students) {
        //학생들의 총점이 저장될 배열생성
        int[] totalScores = new int[students.length];
        for (int i = 0; i < students.length; i++){
            totalScores[i] = students[i].getKorScore() +
                    students[i].getMathScore() +
                    students[i].getEngScore();

        }
        return totalScores;
    }

    //전달된 두 학생 중 총점이 높은 학생 객체를 리턴.
    //단, 전달된 두 학생의 총점이 같은 경우는 없다고 가정.
    @Override
    public Student getHighScoreStudent(Student stu1, Student stu2) {
        int sum1 = stu1.getKorScore() + stu1.getMathScore() + stu1.getEngScore();
        int sum2 = stu2.getKorScore() + stu2.getMathScore() + stu2.getEngScore();

        /* if문으로 풀수도있고 삼합으로도 할수있음

        if ( sum1 > sum2 ) {
            return stu1;
        }
        else {
            return stu2;
        }
        */
        //삼합풀이로 나온 정답!
        return sum1 > sum2 ? stu1 : stu2;

    }






}
