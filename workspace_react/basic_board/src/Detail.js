import { useNavigate, useParams } from "react-router-dom";
import './Detail.css';



const Detail = ({board_list}) => {
  
  //url로 넘어오는 데이터 받기
  const params = useParams();
  const boardNum = params.boardNum; // << 글번호 데이터 받아오는 애 

  let navigate = useNavigate(); // 이친구는 뒤로가기
  const navigate1 = useNavigate(); // 이친구는 삭제하기
  let boardDetail = null;

  for(const e of board_list){
    if(e.boardNum == boardNum ){
      boardDetail = e;
    }

    console.log(boardDetail);
  }

  // board_list.forEach((board_list, i) => {
  //   if(board_list.boardNum == boardNumber){
  //     boardDetail = board_list
  //   }
  // })



  return (
    
  <div className='board1'>
    <h3> 게시글 상세정보 ᕙ(⇀‸↼‵‵)ᕗ </h3>
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>{boardDetail.boardNum}</td>
            <td>작성자</td>
            <td>{boardDetail.writer}</td>
            <td>작성일</td>
            <td>{boardDetail.createDate}</td>
          </tr>
        </thead>
      <tr>
        <td>제목</td>
        <td colSpan={4}>{boardDetail.title}</td>
      </tr>
      <tr>
        <td>내용</td>
        <td colSpan={4}>{boardDetail.content}</td>
      </tr>
    </table>

    <button type='button' onClick={(e) => {navigate(`/`);}}>돌아가기</button>

    <button type='button' onClick={(e) => {
      
      // map을 안쓰는 이유는 return해야하는디 애는 필요없음.
      board_list.forEach((board, i) => {
        if(board.boardNum == boardNum){ //일치하는지 물어보는거 자바랑 같음
          // ▼ 전체 데이터를 들고있는 애
          board_list.splice( i, 1);
          // i번째 1첫번째를 삭제한다. 0은 삭제해야할 번호라서 들어가면 안됨....아마도...!?!!!
        }
      });

      navigate(`/`);

    }}>삭제하기</button> 
    
        
        
  </div>
    



  );
}


export default Detail;