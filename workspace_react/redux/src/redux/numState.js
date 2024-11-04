
//state 변수 num의 초기값을 설정하고
//num의 변수의 값을 변경하는 함수들을 정의 

import { createSlice } from "@reduxjs/toolkit"

const initNum = {
  value : 0

}

//slice : state변수의 초기화 및 함수생성
const numSlice = createSlice({
  name : 'num', //Slic를 구분하기 위한 id 
  initialState : initNum, //state 변수에 저장될 초기값을 셋팅! 
  reducers : { // state변수의 값을 변경하는 함수
    // 첫번째 매개변수 : state변수가 가진 기존 값
    // 두번째 매개변수 : state변수의 값을 변경할 데이터
    addNum : (state) => {
      state.value = state.value + 1;
    }, // 함부로 못바꿈??ㅠㅠ
    subNum : (state, action) => {
      state.value += - 1;
    },
    ressetNum : (state, action) => {
      state.value = 0;
    },
    changeNum : (state, action) => {
      state.value = state.value + action.payload; // payload: 애를 넣어줘야 가져오는 데이터를 확인할수있음 
    }
  }
});

//numSlice.actions : numSlice에 정의된 함수들
export const numActions = numSlice.actions;

//numSlice.numReducer : numSlice 전체내용
export const numReducer = numSlice.actions;