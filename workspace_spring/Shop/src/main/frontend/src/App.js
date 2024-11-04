import './reset.css';
import './App.css';
import { Link, Navigate, Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';
import { useEffect, useState } from 'react';
import RegItem from './pages/admin/RegItem';
import ItemList from './pages/user/ItemList';
import UserList from './pages/admin/UserList';
import { FaShoppingCart } from "react-icons/fa";
import CartList from './pages/user/CartList';
import ItemDetail from './pages/user/ItemDetail';
import Hello from './pages/user/Hello';




function App() {
  const navigate = useNavigate();

  const [isLoginOn, setIsLoginOn] = useState(()=>{
    return localStorage.getItem('isLoginOn') === 'true';
  });

  const handleLogin = () => {
    setIsLoginOn(true);
    localStorage.setItem('isLoginOn','true');
} 

  const handleLogout =()=>{
    setIsLoginOn(false);
    localStorage.removeItem('isLoginON');
  }

  //로그인 정보를 저장할 수 있는 state변수
  const [loginInfo, setLoginInfo] = useState({});

  //로그인 성공 시 loginInfo에 로그인정보를 저장하지만
  // 새로고침하면 app.js 다시 시작하면 logininfon값 초기화됨..
  // 새로고침 하더라도 sessionStorage 로그인정보는 존재하나 새로고침할대 만약 로그인 정보가 sessionStorage 에 남아있다면 loginInfo state변수에 로그인 정보를 저장시켜야함.

  //App.js가 mount(새로고침) 되면 실행
  useEffect(()=>{
    // 세션에 저장된 로그인 정보를 가져옴.
    const sessionLoginInfo = window.sessionStorage.getItem('loginInfo');
    
    //세션에 로그인 정보가 있으면
    if(sessionLoginInfo != null){

      //로그인 정보를 loginInfo에 저장
      // 1. 세션에서 가져온 데이터를 객체로 변환
      const obj_loginInfo = JSON.parse(sessionLoginInfo);
      // 2. 로그인 정보를 loginInfo에 저장
      setLoginInfo(obj_loginInfo);

    }
  },[])

  //빈 객체인지 확인하는 코드
  // Object.keys() -> 객체안의 모든 키 값을 가져옴
  console.log(Object.keys(loginInfo).length);



  return (
  <div className="container">

    {/* 유저, 관리자 공용 */}
    <div className='header'>

      <div className='header-box'>
        <div>
          <img className='banner-img' src='http://localhost:8080/images/books-13.jpg' />
        </div>
        <Link to="/" className="logo">
          GBOOKS
        </Link>
          {
          //로그인이 안되어 있을때
          Object.keys(loginInfo).length == 0 
          ?
          <ul className='login-div'>
            <li>
              <Link to="/loginForm" onClick={handleLogin}>로그인</Link>
            </li>
            <li>
              <Link to="/join">회원가입</Link>
            </li>
            <li>
              <Link to="/hi">임시용</Link>
            </li>
          </ul>
          :
          <div className='logout-box'>
            {loginInfo.memName}님 반갑습니다❤

            <span onClick={()=>{
              // 세션에 저장된 로그인 정보 삭제
              window.sessionStorage.removeItem('loginInfo');

              //loginInfo state 변수의 값을 비워줌
              setLoginInfo({});

              // 상품 목록 페이지로 이동
              alert('로그아웃 하시겠습니까?');
              navigate('/');

            }}>로그아웃</span>

            <span className='cart-div'>
              <p onClick={()=>{navigate('/cartList')}}>장바구니</p>
              <FaShoppingCart />
            </span>

            <Link to="/hi">임시용</Link>

          </div>
          }
          
      </div>
      
      <div className='banner1'>
        {/* <div>
          <img className='banner-img' src='http://localhost:8080/images/books-13.jpg' />
        </div> */}
        <div className='title-div'>
          <p>WELCOM - TO</p>
          <span>GBOOK SHOP</span>
        </div>
      </div>
    </div>

    <div className='layout-div'>
      <Routes>
        {/* 일반회원(USER) 페이지 */}
        <Route path='/' element={ <UserLayout /> } >

          {/* 임시 */}
          <Route path='hi' element={
            isLoginOn ? <Hello /> : <Navigate to='/loginForm'/>
          }
            />


          {/* 회원가입 페이지 */}
          <Route path='join' element={<Join />} />

          {/* 로그인 페이지 */}
          <Route path='loginForm' element={<Login onLogin={handleLogin} setLoginInfo={setLoginInfo} loginInfo={loginInfo} />} />

          {/* 장바구니 페이지 */}
          <Route path='cartList' element={ <CartList />} />

          {/* 상품 목록 화면 */}
          <Route path='' element={ <ItemList />}>
            <Route path='test1' element={<div>1번 화면</div>} />
            <Route path='test2' element={<div>2번 화면</div>} />
          </Route>

          {/* 상품 상세 페이지 */}
          <Route path='itemDetail/:itemCode' element={ <ItemDetail />} />

        </Route>
        
        {/* 관리자용 */}
        <Route path='/admin' element={ <AdminLayout />} >

          {/* 상품 등록 화면 */}
          <Route path='regItem' element={<RegItem /> } />
          
          {/* 유저관리 */}
          <Route path='plusItem' element={<UserList /> } />
          
        </Route>

      </Routes>
    </div>
  </div>
  );
}

// 로그인 페이지 컴포넌트
const Loginn = ({ onLogin }) => {
  const handleSubmit = (e) => {
      e.preventDefault();
      onLogin(); // 로그인 처리
  };
}
export default App;
