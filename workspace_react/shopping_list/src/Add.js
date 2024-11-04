import { useState } from "react";



function Add(props){

  // input태그에 테이터를 저장할 변수
  let [text, setText] = useState('');

  return (
    <div className='box'>
                     {/* onChange: input 태그에 내용이 바뀔때 마다 적힌 글자를 콘솔로 출력함.  */}
      <input type='text' onChange={(e) => {
        setText(e.target.value);
      }}></input>
      <button type='button' onClick={(e) => {
        // input 태그에 입력한 내용을 가져온다.
        // 가져온 내용을 list에 추가한다.
        props.list.push(text);
        console.log(props.list);
        // 변경된 list의 내용으로 setList 함수를 호출
        props.setList([...props.list]);



        
      }}>추가</button>
    </div>
  );
}

export default Add;