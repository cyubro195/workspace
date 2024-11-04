import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

//App() 함수의 리턴문 안에 작성하는 코드가 화면에 나타남.
//html 코드처럼 보이는 것은 실은 jsx라는 문법이다.
//그렇기 때문에 html과 조금 다른 부분이 있다.

function App() {
  

  console.log(1);
  //const titles = ['울산맛집','React공부','집에가고싶다','잠온다'];
  
  //제목정보를 저장하고 있는 변수
  const [titles, setTitles] = useState(['울산맛집','React공부','집에가고싶다','잠온다']);



  //대괄호의 첫번째 : 변수
  //두번째 : 변수의 값을 변경시켜주는 함수
  //ex> setLikeCnt(5); -> likeCnt 변수의 값을 5로 변경
  //useState로 만들어서 변수는 값을 변경하면 html 화면을 재랜더링한다.

  let [likeCnt, setlikeCnt] = useState([0,0,0,0]);
  //아무렇게나 이름 써드댐, 리액트에만 있는 변수를 만드는 방법

  //detail 컴포넌트가 보일지 안보일지 결정하는 변수.(변수의 값이 바뀌면 알아서 바뀜-useState로 바꾸는거임)

  let [isShow, setIsShow] = useState(false); //초기값





  //let [name, setName] = useState('java');
  //let [arr, setArr] = useState([1,2,3]);
  //▲let arr = [1,2,3] 이라고 생각하면 됨;

  function test(){
    alert(1);
  }

  //연습용 자바스크립트 

  //[1,2,3].forEach(function(){}); 애는 구식버전?
 // [1,2,3].map((e, i) => {}); // 이 친구가 최신



  return (

    <div className="App">
      <div className='blog-nav'>
        <h3>My Blog</h3>
      </div>

      {/* {
        [1,2,3].map(() => {
          return (
            // html넣으셈
            <div>💖</div>
          );
        })
      } */}

      <button type='button' onClick={() => {
          const copyTitles = [...titles];
          copyTitles[0] = '대구맛집'
          setTitles(copyTitles); //변경하겠습니다
      }}>제목변경</button>


      {/* <div className='list'>
      <h4 onClick={() => {
            setIsShow(true); > 누르면 상세페이지 나옴!
        }}>
          {titles[0]}
          <span onClick={() => {
            const copyLikeCnt = [...likeCnt];
            copyLikeCnt[0] = copyLikeCnt[0] + 1;
            setlikeCnt(copyLikeCnt);
            //likeCnt = likeCnt + 1; < 애는 자바랑 비슷함
            //원래 가지고 있던 값에 +1 더한다.
          }}>👍🏻</span>
         {likeCnt[0]}
        </h4>
        <p>2024-07-04</p>
      </div>  맨처음 셋팅이였던거 */}


    {/* 블로그 글 목록 */}
    {
      titles.map((title, i) => {
        return (
          <Board title={title} key={i} /> 
                            // ▲ 반복돌릴때 Key값을 넣으면 콘솔에 오류안뜸! 리액트의 약속
        );
      })
    }

    {/* 상세보기 */}
    { //여기에는 ';' 이거 넣으면 안됨!!!
      isShow == true ? <Detail /> : null 
    }

    </div>

  );
}


//상세보기 컴포넌트
//컴포넌트의 리턴문에 html 작성
//모든 HTML 태그는 하나의 최상위 태그에 포함되게 작성.
function Detail(){
  return (
    <div className='detail'>
      <h4>이것은 제목입니다</h4>
      <p>날짜입니다</p>
      <p>라랄ㄹ라랄라 상세내용 블바블바라블랄바르라~~
      </p>
    </div>
  );
}
// ▲ const Detail1 = () => {} 위에랑 같은버전

//블로그 글 하나에 대한 컴포넌트
//전달되는 데이터는 매개변수에 props를 사용해서 전달받음
function Board(props){
  return (
    <div className='list'>
      <h4>
        {props.title}
        <span>👍🏻</span>
        0
      </h4>
      <p>2024-07-05 작성</p>
    </div>
  );
}



export default App;
