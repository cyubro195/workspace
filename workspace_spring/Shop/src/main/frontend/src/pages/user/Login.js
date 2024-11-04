import React, { useState } from 'react'
import '../../reset.css'
import '../user/Login.css'
import Modal from '../../common/Modal';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = ({setLoginInfo, loginInfo}) => {

  const navigate = useNavigate();

  //로그인 버튼 클릭 시 화면에 보여지는 모달창의 상태
  const [beforeLoginModal, setBeforeLoginModal] = useState(false);

  //로그인 쿼리가 실행된 후 보여지는 모달창의 상태
  const [afterLoginModal, setAfterLoginModal] = useState(false);

  //로그인 성공 실패 여부를 저장하는 변수
  const [isLoginSuccess, setLoginSuccess] = useState(false);

  //입력한 id,pw를 저장할 변수
  const [loginData, setLoginData] = useState({
    memId : '',
    memPw : ''
  })

  //입력한 id,pw를 loginData에 저장하는 함수(입력할때마다 실행)
  function changeLoginData(e){
    setLoginData({
      ...loginData,
      [e.target.name] : e.target.value
    })
  }

  //login 버튼 클릭 시 실행
  function login(){
    //id,pw 입력여부 확인!
    if(loginData.memId == '' || loginData.memPw == ''){
      //모달창 상태를 보이게 변경
      setBeforeLoginModal(true);
      return;
    }
    
    axios.post('/api_member/login', loginData)
    .then((res)=>{
      setAfterLoginModal(true); // < 로그인했으면 성공이든 실패든 띄우게하는!!!

      //자바에서 null 데이터가 전달되면 res.data는 빈문자('')가 나옴
      if(res.data == '' ){ // 로그인 실패시..!
        setLoginSuccess(false)

      }
      else{ //로그인 성공시
        setLoginSuccess(true)

        //로그인 정보
        const loginInfo = {
          memId : res.data.memId,
          memName : res.data.memName,
          memRole : res.data.memRole
        };

        //로그인 정보를 가진 객체를 문자열 형태로 변환
        // 객체 -> 문자열로 변환한 데이터를 JSON 데이터로 부른다.
        const json_loginInfo = JSON.stringify(loginInfo); // stringify : 객체를 문자로 바꿔주는 함수


        //sessionStoragy에 로그인한 회원의 아이디,이름,권한정보 등록
        window.sessionStorage.setItem('loginInfo', json_loginInfo);

        //로그인 정보를 저장하기 위해 만든 state 변수 loginInfo(app.js에 생성)에 로그인 정보를 저장
        setLoginInfo(loginInfo);
      }
    })
    .catch((error)=>{console.log(error);});
  }

  //로그인 쿼리 실행 후 띄는 모달 안의 내용
  function drawModalContent(){
    return (
      <>
        {
          isLoginSuccess
          ?
          
          <div> 환영합니다🎉🎉</div>
          :
          <div>ID,PW를 확인해야햇!</div>
        }
      </>
    );
  }

  //로그인 쿼리 실행 후 띄우는 모달안의 확인버튼 클릭 시 실행되는 내용
  function handleBtn(){
    if(isLoginSuccess){ //로그인 성공 시 확인버튼 내용
      //일반유저 로그인 -> 메인페이지
      //관리자 로그인 -> 상품등록페이지
      if(loginInfo.memRole == 'USER'){
        navigate('/')
      }
      else if(loginInfo.memRole == 'ADMIN'){
        navigate('/admin/regItem');
      }
    }
  }

  return (

    <div className='login-container'>

      <div className='login-content'> 
        <div className='login-box'>

          <div className='login-logo'>
            <h1>G<span>BOOKS</span></h1>
          </div>

          <div>
            <div className='login-input'>
              <input type='text' name='memId' placeholder='아이디' onChange={(e)=>{changeLoginData(e)}}/>
            </div>
            <div className='login-input'>
              <input type='password' name='memPw' placeholder='비밀번호' onChange={(e)=>{changeLoginData(e)}} />
            </div>
            <button type='button' className='login-btn' onClick={(e)=>{login()}}>
              로그인
            </button>
          </div>

        </div>
        
        <p> 비밀번호를 잊으셨나요? 네!</p>

      </div>

      {/* 로그인 중 id,pw 입력여부확인 모달창 */}
      {
        beforeLoginModal
        ?
        <Modal  content = {() => {
            return (
              <div>ID,PW 필수입력 ╰（‵□′）╯💦</div>);}}
          setIsShow = {setBeforeLoginModal}
          clickCloseBtn = {()=>{}}/>
        :
        null
      }

      {/* 로그인 쿼리 실행 후 띄는 모달 */}
      {
        afterLoginModal
        ?
        <Modal  content = {drawModalContent}
        setIsShow = {setAfterLoginModal}
        clickCloseBtn = {handleBtn} />
        :
        null
      }
    </div>
  )
}

export default Login