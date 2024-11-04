import axios from 'axios';
import React, { useEffect, useState } from 'react'
import * as boardApi from '../apis/boardApi'
import { useNavigate, useParams } from 'react-router-dom'



const UpdateForm = () => {

  //url로 넘어오는 boardNum 값 받기
  const {boardNum} = useParams();

  const navigate = useNavigate();

  // 게시글 상세정보를 저장할 state 변수
  const [boardDetail, setBoardDetail] = useState({}); //<배열로 넣는거 아님!


  //수정 쿼리 실행 시 빈 값을 채워줄 데이터
  const [updateData, setUpdateData] = useState({
    boardNum : boardNum,
    title : '',
    content : ''
  });




  function changeUpdateData(e){
    setUpdateData({
      ...updateData,
      [e.target.name] : e.target.value
    })
  }


  // 게시글 상세정보 조회
  useEffect(()=>{
  //                        ▼ 글번호 데이터를 연결해줘야함! 
    boardApi.getBoardDetail(boardNum)
    .then((res) => {
      setBoardDetail(res.data);
      setUpdateData({
        ...updateData,
        title : res.data.title,
        content : res.data.content
      });
    })
    .catch((error)=>{console.log(error);})
  },[])

  // 게시글 수정 쿼리 실행
  function updateBoard(){
    boardApi.updateBoard(updateData)
    .then((res)=>{
      alert('수정 ㅇㅋ');
      navigate(`/detail/${boardNum}`);
    })
    .catch((error)=>{
      console.log(error);
    })
  }


  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>작성일</td>
            <td> {boardDetail.createDate} </td>
            <td>작성자</td>
            <td>{boardDetail.memId}</td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>제목</td>
            <td colSpan={3}> <input type="text" name="title" onChange={(e)=>{changeUpdateData(e)}}  value={updateData.title} /> </td>
          </tr>
          <tr>
            <td>내용</td>
            <td colSpan={3}>
              <textarea rows={5} cols={50} name="content" onChange={(e)=>{changeUpdateData(e)}} value={updateData.content} />
            </td>
          </tr>
        </tbody>
      </table>
      <div>
        <button type='button' onClick={(e)=>{navigate(`/`)}}> 뒤로가기 </button>
        <button type='button' onClick={(e)=>{updateBoard()}}> 수정하기 </button>
      </div>
    </div>
  )
}

export default UpdateForm