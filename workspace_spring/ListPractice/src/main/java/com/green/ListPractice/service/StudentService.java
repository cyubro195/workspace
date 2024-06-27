package com.green.ListPractice.service;

import com.green.ListPractice.vo.StudentVO;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.channels.Pipe;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

//학생관리 프로그램의 핵심기능을 정의
public class StudentService {

    //학생을 여러명 저장할 수 이는 통.
    List<StudentVO> list = new ArrayList<>();

    //학생 목록 조회
    public List<StudentVO> getStuList(){
        return list;
    }

    //학생 등록                  자 유 형
    public void regStudent(StudentVO studentVO){
        list.add(studentVO);
    }

    //학생 상세 조회
    public StudentVO getStuDetail(int year){
        //학번이 일치하는 학생을 저장할 공간.
        StudentVO findStudent = null;

        for ( StudentVO studentVO : list){
            if (studentVO.getYear() == year ) { //
                findStudent = studentVO; //우측꺼 왼쪽에 넣겟슴..
            }
        }
        return findStudent;
    }


    //학생 삭제

    public void deleteStu(int year){
        //삭제를 위해서는 삭제할 학생의 index 번호필요
        // ex) list.remove(2)는 0,1,2번째있는 애를 지우겠습니당
        //index를 알기위해서는 학번 데이터가 필요하다!
        int index = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getYear() == year) {
                //리스트에서 한명의 학생의 학번을 뺀다
                index = i;
            }
        }
        list.remove(index);

    }

    //학생 정보 수정
    public void updateStu(StudentVO studentVO){
        //리스트에서 정보를 수정하고자하는 학생을 찾아 그 학생의 정보를
        // input 태그 및 textarea 에서 입력한 정보로 변경한다.

        // 일단 학생을 찾아보작!
        for ( StudentVO student : list ){
            if (student.getYear() == studentVO.getYear()){ //학번!
                student.setName(studentVO.getName());
                student.setKorScore(studentVO.getKorScore());
                student.setEngScore(studentVO.getEngScore());
                student.setIntro(studentVO.getIntro());
            }
        }



    }


}
