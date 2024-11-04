package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    //회원가입
    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join", memberVO);
    }

    //아이디중복
    @Override
    public boolean isEnableId(String memId) {

        //사용 가능한 아이디면 selectedId : null(사용가능)
        String selectedId = sqlSession.selectOne("memberMapper.isEnableId", memId);
        //return selectedId == null ? true : false; or
        return selectedId == null;
    }

    //로그인
    @Override
    public MemberVO login(MemberVO memberVO) {
        // id,pw이 잘못되면 null 데이터가 나온다.
        return sqlSession.selectOne("memberMapper.login",memberVO);
    }
}
