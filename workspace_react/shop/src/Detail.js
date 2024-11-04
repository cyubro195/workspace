
import { useParams } from 'react-router-dom';
import './Detail.css';
import { useEffect, useState } from 'react';


const Detail = ({item_list}) => {

  // url로 전달되는 데이터 받기!

  // 1번 방식
  //const params = useParams();
              // ▲ 애는 객체임.
  //console.log(params);
  //console.log(params.id); 디테일/아이디/그다음꺼 3개써야함! 

  // 우아한 2번방식, 구조분해방..쉭...
  const {id} = useParams();
  
  //console.log(`전달되는 상품번호 : ${id}`);
  // 아이디로만 되어있는 데이터만 받겠습니다 라는 뜻.
  console.log(item_list);

  let findItem = null;

  item_list.forEach((item,i) => {
    if(item.itemNum == id){
      findItem = item;
    }
  }); 

  const [num, setNum] = useState(0);
  const [num1, setNum1] = useState(0);
  
  //useEffect(); 컴포넌트의 라이프싸이클 사이에 필요한 기능을 추가
  // mount(컴포넌트를 새로 읽을 때) + update(재랜더링) 될때 실행
  // useEffect의 두번째 매개변수가 없으면 mount + update 될때 실행!!
  useEffect(()=>{
    console.log(1);
  });


  // mount(컴포넌트를 새로 읽을 때) 될 때 실행.
  // 두번째 매개변수로 빈 배열을 전달하면 mount 될때만 실행...
  //▼이친구 함수임
  useEffect(()=>{
    console.log(2);
  },[]); // < 빈칸에 비워두면 재렌더링 안한다는 뜻. update...? 


  //두번째 매개변수에 배열형태로 state 변수를 넣으면 해당 useEffect는 MOUNT + 배열에 넣은 STATE 값이 변경되어 재랜더링 될ㄸ ㅐ 실행! 
  useEffect(()=>{
    console.log(3);
  },[num]);


  useEffect(()=>{
    console.log(4);
  },[num, num1]);


  useEffect(()=> {

    console.log(5);

    //return 안의 내용은 마운트 될 때 실행 XXXXXXXXX안함 
    //update 될때 실행되는데 가장 먼저 실행 함.
    //unmount 될때도 실행가넝! 

    return () => {
      console.log(6); // mount상태일때는 return안에 있는 값은 안나온다! 재렌더링을 안했기때문에! 
    } //나오게하는방법 : 새로고침하고 콘솔 다 삭제하고 num이라는 state변수가 생기면 나옴!  /  애는 unmount일때도 나옴! 

  },[num]); //[] 빈열이면 mount 일때만 실행! 

  //unmount 될때만 7를 출력
  useEffect(()=>{
    
    return () => {
      console.log(7);
    }
  },[]);




  return (


    <div>

      <button type='buttom' onClick={(e)=>{
          setNum(num+1); }}>
        num값 변경 
      </button>
      <div> num = {num} </div>

      <button type='buttom' onClick={(e)=>{
          setNum1(num1+1); }}>
        num값 변경 
      </button>
      <div> num1 = {num1} </div>  {/* < 애는 재린더링이 되니까 실행이 되는거임! */}



      <div className="item-info">
        <img src={process.env.PUBLIC_URL + '/' + findItem.imgName} />
        <div>
          <h3>{findItem.itemName}</h3>
          <span> 내가 그린 그림은 김그린 </span>
          <p>{findItem.price}</p>
          <button type='button'>주문하기</button>
        </div>  
      </div>

      <div className='intro'>
        이것은 상품 소개글 입니더!
        븗랍ㄹㄹ발바라~~~
      </div>
      
    </div>

    

  );
}



export default Detail;