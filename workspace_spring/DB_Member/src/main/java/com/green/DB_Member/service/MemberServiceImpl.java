package com.green.DB_Member.service;

import com.green.DB_Member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//MemberService 인터페이스의 추상메서드를 구현한 클래스
//해당 클래스에서는 데이터베이스 쿼리 작업을 진행한다.
//Mybatis를 이용해 쿼리 작업을 하기 위해서는
//SqlSessionTemplate 클래스의 객체가 필요하다
//SqlSessionTemplate 클래스에는 쿼리 작업을 윟나 메서드가 정의되어있따.
@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    //데이터베이스에 등록할 회원정보를 만들거다!
    @Override
    public void insertMember(MemberVO memberVO) {
        //첫번째 매개변수 : namespace.쿼리id
        //두번째 매개변수 : 쿼리 실행 시 빈값을 채워줄 데이터
        sqlSession.insert("memberMapper.insertMember", memberVO); //~빈 값 채우겠습니더~
        //sqlSession.commit();
        //sqlSession 임마가 쿼리기능 다~있음!
    }
}
