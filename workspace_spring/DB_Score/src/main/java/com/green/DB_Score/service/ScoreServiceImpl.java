package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scoreService") // 여기에 서비스만 연결하셈
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private SqlSessionTemplate sqlSession; // 요까지는 무조건 똑같이 복붙해서 붙이셈


    @Override
    public List<StudentVO> getStuList() {
       List<StudentVO> list = sqlSession.selectList("scoreMapper.getStuList");

       return list;
    }
}
