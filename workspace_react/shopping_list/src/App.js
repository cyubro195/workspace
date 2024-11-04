import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import List from './List';
import Add from './Add';

function App() {
  //장보기 목록
  const [list, setList ] = useState(['계란 한 판', '생수', '불고기용 돼지고기']);


  
  return (
    <div className="App">
      <div className='container'>

        <h1>Shopping List</h1>
        <List list={list} setList={setList} />
        {/* list라는 함수를 여기에 전달해주는거임 */}
        <Add list={list} setList={setList} />

      </div>
    </div>
  );
}

export default App;
