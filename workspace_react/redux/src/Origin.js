import React, { useState } from 'react'

export const Origin = () => {

  const [num, setNum] = useState(0);

  //+1 함수
  const addNum = () => {
    setNum(num+1);
  }
  
  //-1 함수
  const subNum = () => {
    setNum(num-1);
  }

  //0으로 초기화하는 함수
  const resetNum = () => {
    setNum(0);
  }


  return (
    <div>
      <h3>카운터앱(기존방식)</h3>
      <h3>{num}</h3>
      <div>
        <button type='button' onClick={()=>{addNum()}}>+1</button>
        <button type='button' onClick={()=>{subNum()}}>-1</button>
        <button type='button' onClick={()=>{resetNum()}}>reset</button>
      </div>
    </div>
  )
}
