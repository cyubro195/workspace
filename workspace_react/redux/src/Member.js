import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux';
import { memberActions } from './redux/memberState';

//회원상세정보페이지
const Member = () => {

  //회원정보를 저장하고 있는 변수
  const member = useSelector(state.memberState);
  const dispatch = useDispatch(); //함수를 호출할수있음
  
  useEffect(()=>{
    // 디비에서 조회한 데이터
    const selectedMember = {
      memId : 'java',
      memName : '홍',
      memAge : 30
    };

    //조회한 정보로 store 저장한 member 객체의 정보를 변경
    dispatch(memberActions.changeMemberName('kim'));
  },[]);

  return (
    <div>
      <h3>회원정보페이지</h3>
      <div>
        <div>회원 아이디 : {member.memId}</div>
        <div>회원 이  름 :  {member.memName}</div>
        <div>회원 나  이 :  {member.memAge}</div>
      </div>
    </div>
  )
}

export default Member