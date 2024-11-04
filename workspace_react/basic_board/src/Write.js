

//글쓰기 페이지

import { useState } from "react";
import { useNavigate } from "react-router-dom";
import './Write.css'

const Write = ({board_list, setBoardList}) => {
  // 구조분해할당으로 데이터 서로 따라가게 해주기 위해서 넣어주셈! 

  console.log('등록 전 게시글 목록');
  console.log(board_list);

  // 입력한 모든 정보를 저장하는 state변수

let navigate = useNavigate();

  const [ brd, setBrd ] = useState({

    boardNum : 0,
    title : '',
    content : '',
    writer : '',
    createDate : ''

  });

  function changeBrd(e){
    setBrd({
      ...brd,
      [e.target.name] : e.target.value
      // name = "" 이 네임임...이름 적지말고 ㅠㅠㅠ
    });
  }



  return (

    <div className='board1'>

      <h3> 등 ✺◟(＾∇＾)◞✺ 록 </h3>
      <table>

        <tr>
          <td>글번호</td>
          <td>
            <input type="text" name="boardNum" onChange={(e)=>{
              changeBrd(e);
            }} />
          </td>
        </tr>

        <tr>
          <td>제  목</td>
          <td>
            <input type="text" name="title" onChange={(e)=>{
              changeBrd(e);
            }} />
          </td>
        </tr>

        <tr>
          <td>작성자</td>
          <td>
            <input type="text" name="writer" onChange={(e)=>{
              changeBrd(e);
            }} />
          </td>
        </tr>

        <tr>
          <td >작성일</td>
          <td>
            <input type="date" name="createDate" onChange={(e)=>{
              changeBrd(e);
            }} />
          </td>
        </tr>

        <tr>
          <td>내  용</td>
          <td>
            <textarea name="content" onChange={(e)=>{
              changeBrd(e);
            }}></textarea>
          </td>
        </tr>

      </table>

      <button type='button' onClick={(e) => {
        //board_list.push(brd); 따로 넣으면 brd가 나오고 합치면 밑에처럼하셈! 
        setBoardList([...board_list, brd]);
        navigate(`/`);
      }}>글등록 </button>

      <button type='button' onClick={(e) => {navigate(`/`);}}>돌아가기</button>
    

    </div>
  );
}


export default Write;