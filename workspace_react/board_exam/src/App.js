import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  const [isShow, setIsShow] = useState(false);
  const [index, setIndex] = useState(0);

  const board_list = [
  {

    boardNum : 1,
    title : '첫번째 게시글',
    content : '첫번째 내용임돠',
    writer : '김자바'


  },{

    boardNum : 2,
    title : '두번째 게시글',
    content : '두번째 내용임돠',
    writer : '이자바'

  },{

    boardNum : 3,
    title : '세번째 게시글',
    content : '세번째 내용임돠',
    writer : '최자바'

  }
  ];
  // 게시글 목록은 반복문을 사용할것 (map())
  // 상세보기는 처음에는 화면에 나타나지 않음 -> 글제목을 클릭했을때 나와야함! 
  // 상세보기 컴포넌트를 만들 것.

  return (
    
    <div className="App">
      <div className='container'>
        <table>
          <thead>
            <tr>
              <td>글번호</td>
              <td>제  목</td>
              <td>작성자</td>
            </tr>
          </thead>
            {
              board_list.map((board, i) => {
                return (
                  <tr key={i}> 
                  {/* 중복되지 않을 값 넣어주기 */}
                    <td> {board.boardNum} </td>
                    <td>
                     <span className='title-span' onClick={(()=>{
                      setIsShow(true);
                      setIndex(i);
                     })}>{board.title}</span>  
                    </td>
                    <td> {board.writer} </td>
                  </tr>
                );
              })
            }
          <tbody>
          </tbody>
        </table>
        {
          isShow ? <Detail board={board_list[index]}/> : null
        }
      </div>
    </div>
  );
}

function Detail(props){
  return (
    <div className='detail'>
        글번호 : {props.board.boardNum} <br></br>
        글제목 : {props.board.title} <br></br>
        글내용 : {props.board.content} <br></br>
        작성자 : {props.board.writer} <br></br>
    </div>
  );
}



export default App;
