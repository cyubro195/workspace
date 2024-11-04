

//input 연결하는거 

import { useState } from "react";


const InputTest = () => {
 
  //input 태그에 입력한 내용을 저장하는 변수
  const [inputData, setInputDate] = useState(''); //입력한 변수에 저장하게 만드는 공간!
  const [inputData2, setInputDate2] = useState(''); 
  //왜 만든거냐면...input 변수에 저장할려공...?

  //이렇게 써도 값 변경이 가능함..
  //inputDate = 'dmddmdm';
  //setInputDate('java'); < inputData 변수의 값을 'java'로 변경


  //const [stu, setStu] = useState({}); //초기값넣기
                                 // ▲ 객체넣어주기
  //변수 많을때는 이렇게 만들어주셈!!!                            
  const [stu, setStu] = useState({
    stuNum: '',
    stuName: '',
    age: 0,
    score: 0,
    addr: ''
  });

  
  function changeStu(e){
    setStu({
      ...stu,
      [e.target.name] : e.target.value //그냥 외우셈.
    });
  }

  //이렇게 사용하면 더 간단함!
  // const phone = {
    //   modelName : 'apple',
    //   color : 'black',
    //   price : 300 }
 //=>  ...phone 사용하면 ▲ 안에 내용과 같은거! 
 //즉!!!
  //  const SmartPhone = {
  //   ...phone,
  //   os : 'ios' < 추가적으로 들어갈 부분을 넣어주면됨! 
  //   price : 500
  // ** 만약에 중복으로 값을 넣어주면 값을 바꿀수있음!!!! 가격을 300을 500으로 바꿔줌
  //  }

  return (

    <>

      {/* 방법 1가지  */}
      <div>
        이름 : <input type='text' onChange={(e) => {
          // inputData = e.target.value; < 이렇게 말공
          setInputDate(e.target.value); // < 이캐 

        }} /> <br />
        나이 : <input type='text' onChange={(e)=>{
          setInputDate2(e.target.value);
        }}/>
      </div>


      {/* 방법 2가지  */}

      <div>
        학생명 : <input type='text' name='stuName' onChange={(e)=>{
          changeStu(e);
        }}   /> <br />

        나  이 : <input type='text' name='age' onChange={(e)=>{
          changeStu(e);
        }} /> <br />

        점  수 : <input type='text' name='score' onChange={(e)=>{
          setStu({
            ...stu,
            score : e.target.value
          }); 
        }}/> <br />

        주  소 : <input type='text' name='addr' onChange={(e)=>{
          changeStu(e);
        }}/> <br />
        
        <div>
          이름 : {stu.stuName} <br />
          나이 : {stu.age} <br />
          주소 : {stu.addr} <br />
          점수 : {stu.score} <br />
        </div>
        </div>  
    </>

  );
}




export default InputTest;