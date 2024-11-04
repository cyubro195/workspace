import logo from './logo.svg';
import './App.css';
import data from './data';
import Item_List from './ItemLlist';
import axios from 'axios';
import { Link, Route, Routes } from 'react-router-dom';
import Detail from './Detail';

function App() {

  //상품 목록 데이터 
  const item_list = data; // ◀
  

  //구조분해할당 > 한방에 넣엇댜
  //const arr1 = [1,2,3];
  //const [a,b,c] = arr1;

  
  return (
    <div className="App">
      
      <div className='header'>
        <Link to='/' style={{ textDecoration: "none", color:"#fff", marginRight:"50px", marginLeft:"12px"}}>Book Shop</Link>
        <Link to='/list' style={{ textDecoration: "none", color:"#fff", marginLeft:"20px"}}>상품목록</Link>
        <Link to='/detail' style={{ textDecoration: "none", color:"#fff", marginLeft:"20px"}}>상품상세</Link>
        
      </div>

      <div className='main'>

        <div className='banner'>
          <img src={process.env.PUBLIC_URL + '/header.jpg'} />
        </div>
        
        {/* 이동할 수 있는 페이지의 url들 */}
        <Routes> {/* 실제로 페이지를 이동하게 할 수 있는 버튼 */}

          <Route path='/' element={<div>메인페이지</div>}/>
             {/* path는 url를 의미 */}

          <Route path='/list' element={<Item_List item_list = {item_list} />} />
          
          
          <Route path='/detail/:id' element={<Detail item_list={item_list} />} />                                           {/* 실제 전달받는 데이터 */}
          
          {/* 
              /detail/:id 뒤에 #id붙이면 페이지가 오류안나고 계속 페이지가 나와용.
              : 블라블라 = 아무렇게나 넣어도 된다는 말! 
          */}


          <Route path='*' element={<div>잘못된 페이지 입니다.</div>} />

        </Routes>


        {/* <Item_List item_list = {item_list} /> */}
        
      </div>
      
    </div>
  );
}

const Test =({name, age}) => {//{ name: '홍자바'} age ={20}
  console.log(name);
  console.log(age);

  return (
    <div>으아아아아아</div>
  );
}




export default App;
