package com.green.DB_Member.service;

import com.green.DB_Member.vo.MemberVO;

import java.util.List;

//인터페이스에서는 작성한 쿼리를 실행할 메서드를 정의
//메서드의 매개변수: 실행할 쿼리에 빈값을 채워주는 데이터
//메서드의 리턴타입 : 쿼리 실행결과 데이터베이스에서 가져오는 데이터 타입
public interface DBService {

    //회원번호가 1번인 회원의 이름을 조회하는 쿼리를 실행할 메서드
    String select1();

    //전달된 회원번호를 지닌 회원의 나이를 조회
    int select2(int memNum); //회원번호 하나~가져갑니다.

    //전달받은 나이이상의 회원 이름을 조회
    List<String> select3(int memAge);
    //이름을 여러개 나오니까 리스트로 불러와야함...ㅠ


    //전달받은 회원번호를 지닌 회원의 회원번호,이름,나이,주소 조회
    MemberVO select4(int memNum);

    //모든 회원의 회원번호,이름,나이,주소를 조회
    List<MemberVO> select5();

    //delete, update, insert 리턴타입 : void,int
    //전달받은 회원번호를 가진 회원을 삭제
    int delete(int memNum);
    //영향의 받은 행의 갯수가 나타난...인트...

    void insert(MemberVO memberVO);


    //전달받은 회원번호를 지닌 회원의 이름,나이,주소를 변경하는
    int update(MemberVO memberVO);

}
