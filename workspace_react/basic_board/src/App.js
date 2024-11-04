import logo from './logo.svg';
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import data from './data';
import BoardList1 from './BoardList1';
import Detail from './Detail';
import Write from './Write';
import { useState } from 'react';
import InputTest from './InputTest';




function App() {

  //게시글 목록
  //let board_list = data;

  //이렇게 바꿔주셈용
  const [boardList, setBoardList] = useState(data);

  

  return (

    <div className="App">
      
      <Routes>

        {/* 게시글 목록 페이지 */}
        <Route path='/' element= {<BoardList1 boardList={boardList} />}>
        </Route>
        

        {/* 게시글 상세 페이지 */}
        <Route path='/detail/:boardNum' element={ <Detail board_list={boardList} /> } />

        {/* 글쓰기 페이지 */}
        <Route path='/writeForm' element={<Write board_list={boardList} setBoardList={setBoardList} />} />
        {/* setBoardList 값을 추가해줘서 데이터가 따라가게해주기 */}

        {/* 연습페이지 입니두~~~~ */}
        <Route path='/test' element={<InputTest/>} />
        
      </Routes>

      <div style={{color: "#000"}}> •°⎝(°`ㅁ´ °)⎠°•</div>

      
    </div>
  );
}

export default App;

