package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;

import java.util.List;

public interface StudentService {

    //학생목록 게시글 조회
    List<StudentVO> getStuList();

    //학생 등록
    void insertStu(StudentVO studentVO);

    //학생상세
    StudentVO stuDetail(int stuNum);

    //학생삭제
    void stuDelete(int stuNum);

    //학생점수 수정
    void stuUpdate(StudentVO studentVO);

}
