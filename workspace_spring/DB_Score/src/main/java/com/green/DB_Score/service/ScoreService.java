package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentVO;

import java.util.List;

public interface ScoreService {

    //학생 목록 조회
    List<StudentVO> getStuList();

    //학생 등록
    void insertStudent(StudentVO studentVO);
    //쿼리 실행할땡 ()뭐로 채울꺼야? int stuNum 넣으면 정수로다 넣는다
    //킹치만 애는 int,string 둘 다 있어서 안됨 그래서 전체로 불러줌!

    //상세페이지
    StudentVO getStuDetail(int stuNum);

    //삭제하기
    void delete(int stuNum);

    //수정하기
    void stuUpdate(StudentVO studentVO);

}
