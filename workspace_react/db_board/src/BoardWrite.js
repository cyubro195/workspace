
import axios from "axios";
import { useState } from "react";
import { useNavigate} from "react-router-dom";


const BoardWrite = () => {

let naviagte = useNavigate();
//입력한 내용을 저장하는 state 변수
const[board, setBoard] = useState({
  boardTitle : '',
  boardContent : '',
  boardWriter : ''
});

// 글 등록 버튼 클릭 시 실행하는 함수 
function insertBoard(){

  //빈칸 안올라가게 막는거!
  // 순수 자바스크립트 버전 document.querySelector('input[type="text"]');
  const title_input = document.querySelector('input[name="boardTitle"]');
  if (title_input.value =='' ){
    alert('제목은 필수입력입니다.');
    title_input.focus();
    return ; //리턴문을 만나면 함수가 종료가 되어버림! 아주 많이 씀! 
  }
  if(document.querySelector('input[name="boardWriter"]').value == ''){
      alert('작성자 필수입력임');
      return ;
  }
  
  // 리액트 버전은 투비컨티뉴.....
  // if(board.boardTitle == ''){
  //   alert('제목은 필수입력입니다.');
  // }

  axios
  .post('/regBoard',board)
  .then((res)=>{
    alert('등록완!');
    naviagte(`/`);
  })
  .catch((error)=>{
    alert('오류오류!');
    console.log(error);
  });
}

//입력 값 세팅 함수만들기
function changeBoard(e){
  setBoard({
    ...board,
    [e.target.name] : e.target.value
  });
}

  return (
      <div className="board1" >
        <h2>수정하기 (o′┏▽┓｀o)💦💦</h2>
        <table>
          <tr>
            <td>제 목</td>
            <td>
              <input type="text" name="boardTitle" onChange={(e)=>{
                changeBoard(e)
              }}/>
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td>
              <input type="text" name="boardWriter" onChange={(e)=>{
                changeBoard(e)
              }}/>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <textarea name="boardContent" onChange={(e)=>{changeBoard(e)}}/>
            </td>
          </tr>
        </table>

        <div className="btn-div">
          <button type="button" onClick={(e)=>{naviagte(`/`)}}>돌아가기</button>
          <button type="button" onClick={(e)=>{insertBoard()}}>글등록</button>
        </div>
      </div>

  );
}

export default BoardWrite;