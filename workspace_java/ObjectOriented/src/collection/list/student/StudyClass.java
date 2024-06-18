package collection.list.student;

import java.util.ArrayList;
import java.util.List;

public class StudyClass {

    private List<Student> stuList; // 리스트 선언
    private String className;
    private String teacher;

    //리턴타입 잘 체크해줘야함! 불러오는거 똑같아야행!
    public List<Student> getStuList(){
        return stuList;
    }


    // 생성자
    public StudyClass(String className, String teacher, List<Student>stuList) {
        this.className = className;
        this.teacher = teacher;
        this.stuList = stuList;
    }


    //1번 모든학생 정보출력!!!!
    public void printStuAll(){
        for (Student stu : stuList){
            System.out.println(stu);
        }
    }



}
