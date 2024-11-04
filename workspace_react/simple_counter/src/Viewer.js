


//Viewer 컴포넌트
function Viewer(props){
  return (

    <div className='box'>
      <h3>현재 카운터</h3>
      <p>{props.count}</p>
    </div>

  );
}


export default Viewer; //뷰어라는 컴포넌트를 내보내겠습니다, 하면 쓸수있음