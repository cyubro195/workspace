package collection.list.student;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) {

        //자바반에 소속될 학생 3명 생성
        Student s1 = new Student("김선호",17,80);
        Student s2 = new Student("박주원",17,95);
        Student s3 = new Student("송지태",17,65);

        //자바반에 저장할 학생리스트
        List<Student> stuList1 = new ArrayList<>();//들어갈 공간만들어주기
        //학생 넣어주기 !
        stuList1.add(s1);
        stuList1.add(s2);
        stuList1.add(s3);

        //자바반
        StudyClass javaClass = new StudyClass("자바반","강사 김선재",stuList1);

        //
        //캐드반에 저장될 학생 3명
        Student s4 = new Student("김선달",17,80);
        Student s5 = new Student("최순옥",17,100);
        Student s6 = new Student("강바두",17,86);

        //캐드반 학생들이 저장될 List생성 및 해당 리스트에 캐드반 학생 저장
        List<Student> stuList2 = new ArrayList<>();
        stuList1.add(s4);
        stuList1.add(s5);
        stuList1.add(s6);

        //캐드반 객체 생성 + 캐드반에 위에서 만든 캐드반 학생목록저장
        StudyClass cadClass = new StudyClass("캐드반","강사 김딴딴", stuList2);
        //

        //영상반 만들기!!!!
        Student s7 = new Student("지현우",17,70);
        Student s8 = new Student("남궁민",17,55);
        Student s9 = new Student("독고윤",17,96);

        //영상반 학생들이 저장될 List생성 및 해당 리스트에 영상반 학생 저장
        List<Student> stuList3 = new ArrayList<>();
        stuList1.add(s7);
        stuList1.add(s8);
        stuList1.add(s9);

        //영상반 객체 생성 + 영상반에 위에서 만든 영상반 학생목록저장
        StudyClass mediaClass = new StudyClass("영상반","강사 김에펙", stuList3);

        //교실을 여러개 저장할 수 있는 리스트 만들기
        List<StudyClass> classList = new ArrayList<>();
        classList.add(javaClass);
        classList.add(cadClass);
        classList.add(mediaClass);

        School school = new School(classList); // 이러면 학교안에 모든 데이터가 저장됨!

        //학교 안의 모든 학생의 정보 출력
        for (int i = 0; i < school.getClassList().size(); i++){ // 그 교실의 갯수만큼 반복하겠습니다.
                //<--- 여기까지가 교실(자바반)에서 접근하는중 --->< -- 학생들의 횟수만큼 반복하겠습니다(?) -- >
            for (int j = 0; j < school.getClassList().get(i).getStuList().size(); j++){//억지로..나온거

            }


            school.getClassList().get(8);//학생0번부터 3번 반복하며 출력한다고 생각하면됨!
        }


        school.getClassList();
    }
}
