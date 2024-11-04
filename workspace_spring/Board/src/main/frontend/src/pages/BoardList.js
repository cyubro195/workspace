
import axios from 'axios';
import React, { useEffect, useState } from 'react'
import * as boardApi from '../apis/boardApi';
import { useNavigate } from 'react-router-dom';

const BoardList = ({loginInfo}) => {
  const navigate = useNavigate();
  
  //조회된 게시글 목록을 저장할 변수
  const [boardList, setBoardList] = useState([]);

  //자바에서 가져온 페이지 정보를 담을 변수
  const [pageInfo, setPageInfo] = useState({});

  //검색조건을 저장할 변수
  const [searchData, setSearchData] = useState({
    searchType : 'TITLE',
    searchValue : ''
  });

  function changeSearchData(e){
    setSearchData({
      ...searchData,
      [e.target.name] : e.target.value
    });
  }

  //게시글 목록 조회
  useEffect(() => {
    boardApi.getBoardList()
    .then((res) => {
      //setBoardList(res.data);
      console.log('===mapData===');
      setBoardList(res.data.boardList);
      console.log(res.data)
      setPageInfo(res.data.pageInfo);

    })
    .catch((error) => {
      alert('게시글 목록 조회 오류!');
      console.log(error);
    });
  }, []);


  //검색버튼 누를때 실행되는 함수 
  function searchBoard(){
    boardApi.getBoardList()
    .then((res)=>{
      setBoardList(res.data)
      setPageInfo(res.pageInfo);
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  // 페이징 그리기
  // for문을 이용한 그림 그리기 예제
  function drawPagination(){

    const arr = [];
    if(pageInfo.prev){
      arr.push(<span className='page-span' onClick={(e)=>{getList( pageInfo.beginPage - 1)}}>다음</span>)
    }

    for (let i = pageInfo.beginPage; i < pageInfo.endPage + 1 ; i++){
      arr.push(<span key={i} onClick={(e)=>{getList(i)}} className='page-span'>{i}</span>);
    }

    if(pageInfo.next){
      arr.push(<span className='page-span' onClick={(e)=>{getList( pageInfo.endPage + 1)}}>다음</span>)
    }
    return arr;

    // map을쓰거나 위에처럼 미리 함수로 만들어서 사용해도 된다우.

    //페이징 처리한 곳에서 숫자(페이지번호)를 클릭하면 다시 게시글을 조회
    function getList(pageNo){
      boardApi.getBoardList(pageNo)
      .then((res)=>{
        setBoardList(res.data.boardList);
        setPageInfo(res.data.pageInfo);

      })
      .catch()
    }

  }

  return (
    <div className='board-list-container'>
      <div className='search-div'>
        <select name='searchType' onChange={(e)=>{changeSearchData(e)}}>
          <option value={'TITLE'}>제목</option>
          <option value={'MEM_ID'}>작성자</option>
        </select>
        <input type='text' name='searchValue' onChange={(e)=>{changeSearchData(e)}} />
        <button className='btn' onClick={(e)=>{searchBoard()}}>검색</button>
      </div>
      <div className='board-list-div'>
        <table>
          <colgroup>
            <col width='10%'/>
            <col width='*'/>
            <col width='20%'/>
            <col width='20%'/>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>글번호</td>
              <td>제 목</td>
              <td>작성자</td>
              <td>작성일</td>
            </tr>
          </thead>
          <tbody>
            {
              boardList.map((board, i) => {
                return (
                  <tr key={i}>
                    <td>{boardList.length - i}</td>
                    <td>{board.boardNum}</td>
                    <td>
                      <span onClick={(e) => {navigate(`/detail/${board.boardNum}`)}}>{board.title}</span>
                    </td>
                    <td>{board.memId}</td>
                    <td>{board.createDate}</td>
                  </tr>
                );
              })
            }
          </tbody>
        </table>
      </div>
      <div className='btn-div'>
        {
          loginInfo.memId != null 
          ?
          <button className='btn' onClick={(e) => {navigate('/writeForm')}}>글쓰기</button>
          :
          null
        }
      </div>
      {/* 페이징 정보가 나오는 div */}
      <div>
        {
          drawPagination()
        }
      </div>
    </div>
  )
}

export default BoardList