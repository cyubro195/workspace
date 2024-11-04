package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    //게시글 목록조회
    @Override
    public List<StudentVO> getStuList() {
        List<StudentVO> stuList = sqlSession.selectList("studentMapper.getStuList");
        return stuList;
    }

    //학생등록기능
    @Override
    public void insertStu(StudentVO studentVO) {
        sqlSession.insert("studentMapper.insertStu", studentVO);
    }

    //학생상세정보
    @Override
    public StudentVO stuDetail(int stuNum) {
        return sqlSession.selectOne("studentMapper.stuDetail",stuNum);
    }

    //학생삭제
    @Override
    public void stuDelete(int stuNum) {
        sqlSession.delete("studentMapper.stuDelete" , stuNum);
    }

    @Override
    public void stuUpdate(StudentVO studentVO) {
        sqlSession.update("studentMapper.stuUpdate",studentVO);
    }


}
