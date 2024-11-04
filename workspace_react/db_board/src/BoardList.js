import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";


const BoardList = () => {

  const naviagte = useNavigate();

  //게시글 목록을 저장할 state변수
  const [boardList,setBoarList] = useState([]); // << 빈 배열로 초기값을 줘버령! 

  
  // 게시글 목록 조회한 데이터 받기
  // useEffect 안의 내용은 마지막에 실행됩니당! 느려요~
  useEffect(() => {

    axios
    .get('/boardList') 
    .then((res) => { 
      console.log(res.data);
      setBoarList(res.data);
    }) 
    .catch((error) => {
      console.log('!!!!오류발생!!!\n 개발자 모드로 콘솔 확인하세요!!!');
      console.log(error);
    });

  },[]);



  return (  
    <div>
      <h2> 👉🏻이야호 리스트👈🏻</h2>
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>제 - 목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.map((board,i)=>{
              return(
                <tr key={i}>
                  <td>{board.boardNum}</td>
                  <td>
                    <span onClick={()=>{
                      naviagte(`/detail/${board.boardNum}`);
                    }}>
                    {board.boardTitle}
                    </span>
                  </td>
                  <td>{board.boardWriter} </td>
                  <td>{board.createDate} </td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
      <div className="btn-div">
        <button type="button" onClick={(e)=>{
          naviagte(`/write`);
        }}> 글쓰기 </button>
        
      </div>
      
    </div>
  );
}

export default BoardList;
