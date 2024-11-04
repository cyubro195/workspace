import { useNavigate } from 'react-router-dom';
import './BoardList1.css';



//게시글 목록 컴포넌트
const BoardList1 = ({boardList}) => {

const navigate = useNavigate();

  return (
  <div className='board1'>
    <h1>★이얏호-우 게시판★</h1>
    <table>
      <thead>
        {/* 노반복 구간 */}
        <tr>
          <td>글번호</td>
          <td>제  목</td>
          <td>작성자</td>
          <td>작성일</td>
        </tr>
      </thead>
      <tbody>
        {/* 반복 구간 */}

        {
          boardList.map((board, i)=>{
            return (
              <tr key={i}>
                <td>{board.boardNum}  </td>
                <td>
                  <span onClick={(e)=>{navigate(`/detail/${board.boardNum}`)}}>
                    {board.title}
                    {/* td에는 태그 주지마셈! span 만드셈!  */}
                  </span>
                 {/* <Link to='/detail'>{board.title}</Link> 이런방법도 있음 */}
                </td>
                <td>{board.writer}    </td>
                <td>{board.createDate}</td>
              </tr>
            );
          })
        }
      </tbody>
    </table>
    <button type='button' onClick={(e) => {navigate(`/writeForm`)}}>글쓰기</button>
    
  </div>       
    
  );
}


export default BoardList1;