package com.green.DBTest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TEST_MEMBER 테이블에 데이터를 조작하는 DB 작업을 하는 클래스

//객체만들어주기
//MemberServiceImpl memberService = new MemberServiceImpl();

@Service("memberService")
public class MemberServiceImpl implements MemberService{

    //SqlSessionTemplate 객체 : 쿼리 실행을 위한 메서드를 가지고 있는 객체
    //쿼리 실행을 위한 메서드 총 5개, 객체명은 바뀔수있음! (객체.메소드)
    //데이터 삽입(INSERT) : (객체.insert) => sqlSession.insert("쿼리가 있는 mapper 의 namespace.쿼리 id,[실행할 쿼리의 빈값을 채울 데이터]");
    //데이터 삭제(DELETE) : (객체.DELETE) => sqlSession.delete("쿼리가 있는 mapper 의 namespace.쿼리 id,[]");
    //데이터 수정(UPDATE) : (객체.update) => sqlSession.update("쿼리가 있는 mapper 의 namespace.쿼리 id,[]");
    //데이터 조회(SELECT) : 메소드 2개중에 하나를 써야함!
    //                     1) sqlSession.selectOne("쿼리가 있는 mapper 의 namespace.쿼리 id,[]");
    //                     2)sqlSession.selectList("쿼리가 있는 mappe r의 namespace.쿼리 id,[]");
    //

    @Autowired //맴버변수 위에 올려놔야함.
    private SqlSessionTemplate sqlSession; //db작업하는중

    //TEST_MEMBER 테이블에 데이터 1개 삽입
    @Override
    public void insertMember() {
        sqlSession.insert("memberMapper.insert1"); //< 오류 제일 많이 나는곳! 주의하세요!
    }

    @Override
    public void insertMember2() {
        //쿼리가 있는 mapper 의 namespace.쿼리 id
        sqlSession.insert("memberMapper.insert2", 20);
    }
}
