import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import { Origin } from './Origin';
import UseRedux from './UseRedux';
import Member from './Member';


//redux-toolkit 설치 명령어 : npm install @reduxjs/toolkit react-redux

//Redux 용어정리 (redux-toolkit)에서 사용하는 용어
//store : 모든 State변수를 저장하고 관리하는 저장소, 하나의 프로젝트에는 하나의 store만 사용가능
//Action : stoRE에 저장된 state 변수의 값을 변경할 데이터
//Reducer : state값을 변경하기위해 실행되는 함수를 의미함.
//Dispatch : reducer를 실행시켜주는 함수 ~_~

//useSelector() : store에 저장된 state변수값 가져오기
//useDispacth() : state변수의 값을 변경시키는 함수 호출에 사용

function App() {

  const navigate = useNavigate();
  return (
    <div className="App">
      


      <Routes>
        <Route path='/' element={
          <div>
            <h3 onClick={()=>{navigate('/origin')}}>숫자카운터 (기존방식)</h3>
            <h3 onClick={()=>{navigate('/useRedux')}}>숫자카운터 (redux 사용)</h3>
          </div>
        } />
        <Route path='/origin' element={<Origin/>} />
        <Route path='/useRedux' element={<UseRedux/>} />
        <Route path='/useRedux' element={<Member />} />
      </Routes>

    </div>
  );
}

export default App;
