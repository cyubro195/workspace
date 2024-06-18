package collection.list;

//학생이름, 국어점수, 영어점수, 총점 데이터
//1) 리스트에 저장된 모든 정보를 출력해보세요.
//2) 총점이 150점 이상인 학생의 모든 정보를 출력하세요.
//3) 모든 학생에 대한 평균 점수를 출력하세요.
//4) 총점이 1등인 학생의 모든 정보를 출력해보세요.

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        //학생 3명 정보 넣기
        Student s1 = new Student("김히동",80,90);
        Student s2 = new Student("마석두",90,70);
        Student s3 = new Student("곽필구",60,70);
        //리스트 집어넣긜
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        //1번 저장된 모든 정보 출력
        System.out.println(" 1) 리스트에 저장된 모든 정보 : ");
        for (Student student : studentList) {
            System.out.println(student);
        }

        //2번 총점이 150점 이상인 학생의 모든 정보를 출력
        System.out.println(" 2) 총점 150점 이상인 학생");

        //쌤 풀이
        for(int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getTotalScore() >= 150){
                System.out.println(studentList.get(i));
            }
        }
/*

        for (Student student : studentList){
            if (student.getTotalScore() >= 150){
                System.out.println(student);
            }
        }
*/

        //3번 모든 학생에 대한 총점에 대한 평균점수 출력

        int sum = 0; //총점구하기
        for (Student student : studentList){
            sum = sum + student.getTotalScore();
        }
        System.out.println((double)sum / studentList.size());


        //4번 총점이 1등인 학생의 모든정보를 출력!
        //*꿀팁* 리스트 쓸 때는 get size move만 쓰면됨

        int index = 0; // 총점이 1등인 학생의 index
        int max = 0; //가장 높은 총점

        for (int i = 0; i < studentList.size(); i++ ){
           if (max < studentList.get(i).getTotalScore()){//학생총점 빼야하니까 넣어주기
               max = studentList.get(i).getTotalScore(); //가장 높은 점수
               index = i; // 가장 높은 점수를 가진학생을 i 에 넣어주기
           }
        }
        System.out.println(studentList.get(index));



    }
}
