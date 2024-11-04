
//=== 게시판 테이블에서 사용하는 axios 모음 ===//

import axios from "axios"

//게시글 목록 조회
export const getBoardList = (pageNo) => {
  const response = axios.post('/board/list', {'pageNo' : pageNo});
  // 데이터 조회 get은 하나만 됨, 2개쓸려면 post로 바꿔주야함! 
  return response;
}

//게시글 등록
export const insertBoard = (data) => {
  const response = axios.post('/board/insert', data);
  return response;
}

//게시글 상세 조회
export const getBoardDetail = (boardNum) => {
  const response = axios.get(`/board/detail/${boardNum}`);
  return response;
}

//게시글 수정
export const updateBoard = (data) => {
  const response = axios.put(`/board/update`, data);
  return response;
}