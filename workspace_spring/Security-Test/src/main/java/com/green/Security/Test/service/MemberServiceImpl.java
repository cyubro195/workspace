package com.green.Security.Test.service;

import com.green.Security.Test.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.SQL;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
//@NoArgsConstructor // 생성자를 만들건데 매개변수로 없는 생성자 만들어줘????? 람북으로 생성자를 만들수있음.
//@AllArgsConstructor // 모든 매개변수(선언한 변수들)를 갖는 생성자를 자동으로 만들어줌.
@RequiredArgsConstructor // << lombok 람북꺼
public class MemberServiceImpl implements MemberService{
    //생성자 주입
    // 기존과 달라진점
    // 1. 선언한 객체 위의 어노테이션 사라짐
    // 2. 선언한 변수에 final 키워드가 붙는다
    // 3. 클래스에 @RequiredArgsConstructor 어노테이션이 붙는다

    //필드주입
    private final SqlSessionTemplate sqlSession; //final 넣으면 더이상 변하지않음 초기값 넣거나 생성자만들기

//    @Autowired // 생정자가 1개이면 생략가능!
//    public  MemberServiceImpl(SqlSessionTemplate sqlSession){
//        this.sqlSession = sqlSession;
//    } RequiredArgsConstructor 이친구를 넣으면 여기는 생략해도됨!!!@!@!


    @Override
    public void test1() {
        System.out.println(111);
    }

    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join", memberVO);
    }
}
