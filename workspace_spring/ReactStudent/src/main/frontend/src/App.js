import './reset.css'
import './App.css';
import { Link, Route, Routes } from 'react-router-dom';
import StudentList from './StudentList';
import StudentReg from './StudentReg';
import StudentDelete from './StudentDelete';
import StudentGrade from './StudentGrade';
import StudentDetail from './StudentDetail';
import StuForm from './StuForm';
// * : 전부 > 전부를 가져와라!!!! 

function App() {

  //api 애들 불러오는 법 
  // api.myName;
  // api.myAge;
  // api.myPrint2();


  return (
    <div className="App">
      <div className='container'>

        {/* 목차 헤더임 */}
        <div className='header'>
          
          <ul>
            <li>
              <Link to="/stulist">
                학생정보조회
              </Link>
            </li>
            <li>
              <Link to="/stureg">
                학생등록
              </Link>
            </li>
            <li>
              <Link to="/studel">
                학생삭제
              </Link>
            </li>
            <li>
              <Link to="/stugrd">
                성적관리
              </Link>
            </li>
          </ul>

        </div>



    <div className='content'>
     {/* 컨텐츠 영역 */}
      <Routes>

        {/* 학생 정보 조회 페이지 */}
        <Route path='/stulist' element={<StudentList />}/>

        {/* 학생 등록 페이지 */}
        <Route path='/stureg' element={<StudentReg />} />

        {/* 학생 삭제 페이지 */}
        <Route path='/studel' element={<StudentDelete />} />

        {/* 성 적 관 리 페이지 */}
        <Route path='/stugrd' element={<StudentGrade />} />

        {/* 학생 정보 상세 페이지 */}
        <Route path='/detail/:stuNum' element={<StudentDetail />} />

        {/* 학생성적 수정페이지 */}
        <Route path='/stuForm/:stuNum' element = {<StuForm />} />

      </Routes>

    </div>


    </div>
  </div>
  );
}

export default App;
