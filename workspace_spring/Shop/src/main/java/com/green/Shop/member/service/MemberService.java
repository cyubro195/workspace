package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

public interface MemberService {

    //회원가입
    void join(MemberVO memberVO);

    //아이디 중복체크
    //사용가능하면 ? true, 사용불가 : false
    boolean isEnableId(String memId);

    //로그인
    MemberVO login(MemberVO memberVO);
}
