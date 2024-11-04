import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Viewer from './Viewer';
import Controller from './Controller';

function App() {

  console.log(1); //재렌더링(자동으로 다시)되는데 새로고침이랑 다른느낌임!

  let[count, setCount] = useState(0);

// 함수만들때 앞글자를 대문자로 만들어주면 컴포넌츠로 인식함
// 소문자로 할때는 함수로 인식함, 사실상 위 아래 우ㅣㅣ윙 아래 
  function changeCount(num){
    //console.log(num);

    const result = count + Number(num);
    console.log(result);
    setCount(result);  //변수의 값을 n으로 바꾼댱.

  }

  // count = 10; or setCount(10);

  return (
    <div className="App">

      <div className='container'>
        <h1>Simple Counter</h1>
        <Viewer count={count} />
        {/* 전달받은값 , 전달받을곳 */}
        
        <Controller setCount={setCount} count={count} changeCount={changeCount} />
                {/* 전달받은값,전달받을곳 */}
      </div>
    </div>
  );
}







export default App;
