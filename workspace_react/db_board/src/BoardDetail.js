import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";




const BoardDetail = () => {
  
  //Route의 url로 전달되는 데이터 받기
  const {boardNum} = useParams();

  //상세정보를 저장할 state변수
  const [detail,setBoardDetail] = useState({});
    // '[]' 빈 배열보다는 객체 넣어주는게 좋! ▲

  const naviagte = useNavigate();





  //DB에서 상세조회한 내용을 화면에 출력
  useEffect(() => {
    axios
    .get(`/boardDetail/${boardNum}`)
    .then((res) => {
      console.log(res.data);
      setBoardDetail(res.data);
    })
    .catch((error) => {
      alert('오류오류오류');
      console.log(error);
    });

  }, []);



  //삭제하기 만들기
  function boardDelete(){
    if(window.confirm('ㄹㅇ삭제?')){  //입력하면 타겟을 눌렀을때 요청사항이 뜸! 
      axios //오직 자바에서만 삭제할수있기때문에 자바로 넘어갈려면 axios를 불러야함! 
      .delete(`/boardDelete/${detail.boardNum}`) //데이터가 있을경우에는 그냥 넣어주면됨! 없으면 useparams하면됨 
      .then((res) => {
        alert('삭제 완!');
        naviagte(`/`);
      })
      .catch((error) => {
        alert('삭제 실패!');
        console.log(error);
      }); 
    }
  }

  return (

    <div className="board1">
      <h2> 🙏🏻 이야호 상세보기 🙏🏻</h2>
      <table>
        <thead>
          <tr>
            <td>글번호</td>
            <td>{detail.boardNum}</td>
            <td>작성자</td>
            <td>{detail.boardWriter}</td>
            <td>작성일</td>
            <td>{detail.createDate}</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>제목</td>
            <td colSpan={5}>
            {detail.boardTitle}
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={5}>
            {detail.boardContent}
            </td>
          </tr>
        </tbody>
      </table>

      <div className="btn-div">
        <button type="button" onClick={(e)=>{naviagte(-1)}}> 뒤로가기1 </button>
                                                    {/* ▲ 이친구는 전페이지로 돌아가는거 */}
        <button type="button" onClick={(e)=>{naviagte(`/`)}}> 뒤로가기2 </button>
                                                  {/* ▲ 이친구는 리스트 페이지로 돌아가는거 */}
        <button type="button" onClick={(e)=>{
          naviagte(`boardDelete/${detail.boardNum}`)
        }}> 삭제 </button>
      </div>
    </div>

  );
}

export default BoardDetail;