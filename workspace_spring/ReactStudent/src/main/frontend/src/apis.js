

//서버와 통신하는 기능을 모아놓은 js

import axios from "axios";


//학생목록 조회 api
//xport const stuList = axios.get('/stuList');
//한번 조회한 데이터를 호출해온다! 
// 이렇게하면 전체적으로 돌려서 쓸수있음! 


//함수로 풀어주면 가능해요! ▼
export const getStuList = () => {
  const response = axios.get('/stuList');
  return response;
}

//파람은..리액트라서 넣으면 안됭...온니 자바스크립으로 하는곳임..
export const getStuDetail = (stuNum) => {
  const response1 = axios.get(`/stuDetail/${stuNum}`);
  return response1;
}


//학생의 점수 정보 등록(변경)

export const getStuUpdate = (stuGrd) => {
  const response = axios.put(`/stuUpdate`,stuGrd);
  return response;

}











//다른방식! 근데 위에꺼를 더 추천함.
// export function stuList11(){
//   const response = axios.get('/stuList');
//   return response;
// }


// 설명글 ▼
// export const num = 10;
// export const getNum = () => {
//   const num = 10;
//   return num; }





//export let myName = 'kim';
//export let myAge = 30;
// export const myPrint = ()=>{
// console.log(1)
// }
// ◆둘다 내보내기 쌉가능! 

// export function myPrint2(){
//   console.log(2);
// }

