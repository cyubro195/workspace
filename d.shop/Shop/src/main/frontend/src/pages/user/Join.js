
import React, { useRef, useState } from 'react'
import './Join.css'
import { useDaumPostcodePopup } from 'react-daum-postcode';
import axios from 'axios';
import Modal from '../../common/Modal';
import { useNavigate } from 'react-router-dom';
import { joinValidate } from '../../validate/joinValidate'; 

const Join = () => {
  const navigate = useNavigate();

  //daum 주소 api 팝업창을 띄우기 위한 함수 선언
  const open = useDaumPostcodePopup();

  //주소 검색 팝업창이 닫힐 때 실행되는 함수
  function handleComplete(data){
    //우편번호
    console.log(data.zonecode);
    //도로명주소
    console.log(data.roadAddress);

    //input 태그에 검색한 내용 넣어주기!
    setJoinData({
      ...joinData,
      post : data.zonecode,
      memAddr : data.roadAddress
    });
  }

  //검색 버튼 클릭 시 실행되는 함수
  function handleClick(){
    open({onComplete : handleComplete});
  }

  //태그를 참조하는 변수
  const email_1 = useRef();
  const email_2 = useRef();

  //회원 가입 쿼리 시 가져갈 데이터
  const [joinData, setJoinData] = useState({
    memId : '',
    memPw : '',
    confirmPw : '',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  const memId_valid_tag = useRef();
  const memName_valid_tag = useRef();

  const valid_tag = useRef([]);

  function changeJoinData(e){
    //입력한 데이터
    const newData = {
      ...joinData,
      [e.target.name] : e.target.name != 'memEmail' ? 
                                          e.target.value : 
                                          email_1.current.value + email_2.current.value
    }

    //입력한 데이터에 대한 validation 처리
    //validation 처리
    joinValidate(newData, valid_tag);

    //유효성 검사 끝난 데이터를 joinData에 저장
    setJoinData(newData);
  }

  //회원가입 버튼 클릭 시 insert 쿼리 실행하러 가기
  function join(){
    axios.post('/api_member/join', joinData)
    .then((res) => {
      //모달창 띄움
      setIsShow(true);

      //로그인 페이지로 이동
    })
    .catch((error) => {
      console.log(error);
    });
  }

  //모달창 랜더링 여부
  const [isShow, setIsShow] = useState(false);

  //모달창 안의 내용을 생성하는 함수
  function setModalContent(){
    return (
      <div>회원가입을 축하합니다.</div>
    );
  }


  return (
    <div className='join-div'>
      <div>
        <table className='join-table'>
          <tbody>
            <tr>
              <td>아이디</td>
              <td>
                <div className='inline-input'>
                  <input className='form-control' type='text' 
                        name='memId' onChange={(e) => {changeJoinData(e)}}/>
                  <button className='btn btn-primary' type='button'>중복확인</button>
                </div>
                <div className='feedback' ref={valid_tag[0]}></div>
              </td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td>
                <input className='form-control' type='password'
                      name='memPw' onChange={(e) => {changeJoinData(e)}}/>
              </td>
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td>
              <input className='form-control' type='password'
                    name='confirmPw' onChange={(e) => {changeJoinData(e)}}/>
              </td>
            </tr>
            <tr>
              <td>이름</td>
              <td>
                <input className='form-control' type='text'
                    name='memName' onChange={(e) => {changeJoinData(e)}}/>
                <div className='feedback' ref={valid_tag[1]}></div>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td>
              <input className='form-control' type='text' placeholder='숫자만 입력하세요'
                      name='memTel' onChange={(e) => {changeJoinData(e)}}/>
              </td>
            </tr>
            <tr>
              <td>주소</td>
              <td>
                <div className='inline-input'>
                  <input value={joinData.post} className='form-control' type='text' placeholder='우편번호' readOnly={true} onClick={handleClick}
                          name='post' onChange={(e) => {changeJoinData(e)}}/>
                  <button className='btn btn-primary' type='button'
                        onClick={handleClick}>검 색</button>
                </div>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input value={joinData.memAddr} className='form-control' type='text' placeholder='주소' readOnly={true} onClick={handleClick}
                      name='memAddr' onChange={(e) => {changeJoinData(e)}}/>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input className='form-control' type='text' placeholder='상세주소'
                      name='addrDetail' onChange={(e) => {changeJoinData(e)}}/>
              </td>
            </tr>
            <tr>
              <td>이메일</td>
              <td>
                <div className='inline-select'>
                  <input className='form-control' type='text' ref={email_1}
                        name='memEmail' onChange={(e) => {changeJoinData(e)}}/>
                  <select className='form-control' ref={email_2}
                          name='memEmail' onChange={(e) => {changeJoinData(e)}}>
                    <option value={'@naver.com'}>naver.com</option>
                    <option value={'@google.com'}>google.com</option>
                  </select>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={(e) => {join()}}>회원가입</button>
      </div>

      {/* 회원가입 성공 시 열리는 모달 */}
      {
        isShow 
        ? 
        <Modal content={setModalContent} setIsShow={setIsShow}/> 
        : 
        null
      }
    </div>
  )
}


export default Join