
import React, { useRef, useState } from 'react'
import '../user/Join.css';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import axios from 'axios';
import Modal from '../../common/Modal';
import * as memberApi from '../../apis/memberApi'
import { useNavigate } from 'react-router-dom';
import { joinValidate } from '../../validate/joinValidate';



const Join = () => {

  //id 중복체크 여부를 저장할 변수
  const [isCheckId, setIsCheckId] = useState(true);

  //daum 주소 api 팝업창을 띄우기 위한 함수선언
  const open = useDaumPostcodePopup();
  
  //네비게이트
  const navigate = useNavigate();

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
    })

  }

  //주소 검색버튼 클릭 시 실행되는 함수
  function handleClick(){
    open({onComplete : handleComplete});
  }

  // input 태그를 참조하는 변수
  const email_1 = useRef();
  const email_2 = useRef();


  //회원가입 쿼리 시 가져갈 데이터
  const [joinData, setJoinData] = useState({
    memId : '',
    memPw: '',
    confirmPw:'',
    memName:'',
    memTel:'',
    post:'',
    memAddr:'',
    addrDetail:'',
    memEmail:''
  });


  //태그를 참조할수있음
  const memId_valid_tag = useRef();  //아이디
  const memPw_valid_tag = useRef(); //비밀번호
  const confirmPw_valid_tag = useRef(); //비밀번호 확인
  const memName_valid_tag = useRef(); //이름
  const memTel_valid_tag = useRef(); //번호

  const valid_tag = [
    memId_valid_tag
    ,memPw_valid_tag
    ,confirmPw_valid_tag
    ,memName_valid_tag
    ,memTel_valid_tag
  ];

  
  //유효성 검사 결과를 저장하는 변수
  const [valid_result, setvalidResult] = useState(false);

  function changeJoinData(e){
    // 입력한 데이터
    const newData = {
      ...joinData,
        [e.target.name] : e.target.name !== 'memEmail' ? 
                                            e.target.value :
                                            email_1.current.value + email_2.current.value
    }

    // 입력한 데이터에 대한 validation 처리
    // validation 처리 : 모든 데이터가 유효한 데이터면 리턴 true 
    const result = joinValidate(newData, valid_tag, e.target.name);
                                      //▲ 애를 넣어야 input값이 들어감!!!!
    setvalidResult(result);

    //유효성 검사 끝난 데이터를 joindata에 저장! 
    setJoinData(newData);

  }


  //회원가입 버튼 클릭 시 insert 쿼리 실행하러 가기
  function join(){
    //유효성 검사 결과가 false면 회원가입 로직 중지
    if(!valid_result){
      alert('입력 데이터를 확인하셈');
      return ; //리턴값에 아무것도 안주면 진행안되고 끝나버림! 
    }

      //id중복검사했는지 확인 -> 가입ㅇㅋ
    if(!isCheckId){
      alert('ID중복검사 후 가입하세요');
      return ;
    }

    axios.post('/api_member/join', joinData)
    .then((res)=>{
      //모달창 띄움
      setIsShow(true);
    })
    .catch((error)=>{
      console.log(error);
    })
  }


  //중복확인 버튼 클릭 시 실행
  function isEnableId(){

     //아이디 빈값 콘솔
    if(joinData.memId == ''){
      alert('ID를 입력해주세요!( °ᗝ° ).ᐟ.ᐟ')
      return ;
    }

    axios.get(`/api_member/isEnableId/${joinData.memId}`)
    .then((res)=>{
      if(res.data){
        alert('사용 가능한 ID입니다 (´▽`ʃ♡ƪ)')
        setIsCheckId(true);
      }
      else{
        alert('중복된 아이디(╬▔皿▔)╯')
      }
    })
    .catch((error)=>{
      console.log(error);
    });
  }


  //모달창 랜더링 여부
  const [isShow, setIsShow] = useState(false);

  // 모달창 안의 내용을 생성하는 함수
  function setModalContent(){
    return(
      <div>
      <h3>✨ 모달창 OPEN ✨</h3>
        <hr />
      <p>
        💗💗💗님!!!<br/>
        🎉🎉가입을 축하합니다 뺭뺭뺭!!🎉🎉
      </p>
    </div>
    );
  }

  // 모달창을 닫으면 실행되는 함수 
  function onClickModalBtn(){
    navigate('/loginForm')
  }


  return (
    <div className='join-div'>

      <h2>회원가입</h2>
      <hr />

      <table className='join-box'>
        <colgroup>
          <col width='30%' />
          <col width='*' />
        </colgroup>
        <thead>
        <tr>
          <td>아이디</td>
          <td>
            <input type='text' placeholder='아이디를 입력하세요' className='small-input' name='memId' onChange={(e) => { changeJoinData(e); setIsCheckId(false); }}/>
            <button type='button' className='join-btn' onClick={(e)=>{isEnableId()}}> 중복확인 </button>
            <div className='feedback' ref={valid_tag[0]}></div>
          </td>
        </tr>

        <tr>
          <td>비밀번호</td>
          <td>
            <input type='password' className='form-control' placeholder='비밀번호를 입력하세요' name='memPw' onChange={(e) => {changeJoinData(e)}}/>
            <div className='feedback' ref={valid_tag[1]}></div>
          </td>
        </tr>
        <tr>
          <td>비밀번호 확인</td>
          <td>
            <input type='password' placeholder='비밀번호를 다시 입력하세요' className='form-control' name='confirmPw' onChange={(e) => {changeJoinData(e)}}/>
            <div className='feedback' ref={valid_tag[2]}></div>
          </td>
        </tr>
        <tr>
          <td>이름</td>
          <td>
            <input type='text' className='form-control'
                  name='memName' onChange={(e) => {changeJoinData(e)}}/>
            <div className='feedback' ref={valid_tag[3]}></div>
          </td>
        </tr>
        <tr>
          <td>연락처</td>
          <td>
            <input type='text' placeholder='숫자만 입력하세요' name='memTel' className='form-control' onChange={(e) => {changeJoinData(e)}}/>
            <div className='feedback' ref={memTel_valid_tag}></div>
          </td>
        </tr>
        <tr>
          <td>주소</td>
          <td>
            <input type='text' placeholder='우편번호' className='small-input' value={joinData.post}
            name='post' onChange={(e) => {changeJoinData(e)}} readOnly={true} onClick={handleClick} />
            <button type='button' name='search' className='join-search-btn' onClick={handleClick} >검 색</button><br/>
            <input type='text' placeholder='주소' className='form-control' value={joinData.memAddr} onClick={handleClick}
            name='memAddr' onChange={(e) => {changeJoinData(e)}} readOnly={true} /><br/>
            <input type='text' placeholder='상세주소 입력' className='form-control'
            name='addrDetail' onChange={(e) => {changeJoinData(e)}}/>
          </td>
        </tr>
        <tr>
          <td>이메일</td>
          <td>
            <input type='text'  className='small-input' name='memEmail' ref={email_1}
              onChange={(e) => {changeJoinData(e)}}  />
            <select name='memEmail' ref={email_2} onChange={(e) => {changeJoinData(e)}}>
              <option value={'@naver.com'}>@naver.com</option>
              <option value={'@gmail.com'}>@gmail.com</option>
            </select>
          </td>
        </tr>
        </thead>
      </table>
      <hr />
      <button type='button' name='join' className='btn1' onClick={(e)=>{join()}}>회원가입</button>

      {/* 회원가입 성공 시 열리는 모달 */}

      {
        isShow
        ?
        < Modal content={setModalContent} setIsShow={setIsShow} clickModalBtn={onClickModalBtn} /> 
        :
        null
      }

    </div>
  )
}

export default Join