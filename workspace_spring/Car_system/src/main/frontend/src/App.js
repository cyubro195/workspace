import { Link, Route, Routes, useNavigate } from 'react-router-dom';
import './App.css';
import './reset.css';
import CarList from './pages/CarList';
import SalesInfo from './pages/SalesInfo';
import SalesList from './pages/SalesList';
import CarHome from './pages/CarHome';


function App() {
  const navigate = useNavigate();

  return (
    <div className="m-container">

      <div className='header'>
        <div className='logo' onClick={(e)=>{ navigate('/')}}>
          <h1>CARZ</h1>
        </div>
        <ul className='nav'>
          <li>
            <Link to ="/" >홈</Link>
          </li>
          <li>
            <Link to ="/carList" >차량관리</Link>
          </li>
          <li>
            <Link to ="/salesInfo" >판매정보 등록</Link>
          </li>
          <li>
            <Link to ="/salesList" >판매목록</Link>
          </li>
        </ul>
        <img className='main-img' src='http://localhost:8080/images/car.jpg' />
      </div>

      <div className='m-content'>

        <Routes>

          {/* 홈 */}
          <Route path='/' element={ <CarHome />} />

          {/* 차량관리 */}
          <Route path='/carList' element={ <CarList />} />

          {/* 판매정보 등록 */}
          <Route path='/salesInfo' element={ <SalesInfo />} />

          {/* 판매 목록 */}
          <Route path='/salesList' element={ <SalesList />} />


        </Routes>
      </div>

    </div>
  );
}

export default App;
