

function Controller(props){
  console.log(2);
  //새로고침을 하면 로그애들이 차례대로 나타남! 

  return (

  <div className='box'>

    <button type='button' value="-10" onClick={(e) => {
      props.changeCount(e.target.value);}}> -10 </button>

    <button type='button' value="-1" onClick={(e) => {
      props.changeCount(e.target.value);}}>- 1</button>


      {/* 반복이 귀찮으니 함수로 바꿔쥬세용 */}
    <button type='button' value="+1" onClick={(e) => {
         props.changeCount(e.target.value);
        // e.target
        // target : 현재 이벤트가 발생하고 있는 태그
     }}>+ 1</button>

      {/* 애랑 동일한 문법임 onClick={function()()} */}
    <button type='button' value="+10" onClick={(e) => {
     props.changeCount(e.target.value);}}>+ 10</button>

  </div>


  );

}

export default Controller;