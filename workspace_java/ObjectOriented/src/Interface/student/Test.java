package Interface.student;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        MyStudent s = new MyStudent();

        Student[] students = new Student[5];// 학생이 들어갈 통을 5개 만드는거임..!
        Student s1 = new Student("김",80,70,90);
        Student s2 = new Student("이",70,80,90);
        Student s3 = new Student("박",80,70,70);
        Student s4 = new Student("최",90,90,90);
        Student s5 = new Student("독고",60,70,50);

        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;

        System.out.println();
        //챕터1번답
        System.out.print("1번째 정답 : ");
        String result1 = s.getGradeByStudentName(students,"최");
        System.out.println(result1);


        System.out.println();
        //챕터2번답
        System.out.print("2번째 정답 : ");
        int[] result2 = s.getTotalScoresToArray(students);
        System.out.println(Arrays.toString(result2));



        System.out.println();
        //챕터3번답
        System.out.print("3번째 정답 : ");
        Student stu = s.getHighScoreStudent(s1,s2);
        System.out.println(stu.getName());
    }
}
