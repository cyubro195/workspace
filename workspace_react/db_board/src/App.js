import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import AxiosTest from './AxiosTest';
import BoardDetail from './BoardDetail';
import BoardWrite from './BoardWrite';

function App() {
  return (
    <div className="App">

      <Routes>

        {/* axios 예제 페이지 */}
        <Route path='/axios' element={ <AxiosTest />}/>  

        {/* 게시글 목록 페이지 */}
        <Route path='/' element={ <BoardList />}/>

        {/* 상세보기 페이지 */}
        <Route path='/detail/:boardNum' element={ <BoardDetail />}/>

        {/* 글쓰기 페이지 */}
        <Route path='/write' element={ <BoardWrite />}/>


      </Routes>

    </div>
  );
}

export default App;
