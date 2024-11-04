import './App.css';
import axios from 'axios';


// await -> 비동기를 동기화시켜주는 명령어!
// 근데 이 명령어는 단독으로 쓸 수 없음, 반드시 async 명령어랑 함께 사용해야함! 

//async -> 동기를 비동기화 만들어줌...
function App() {
  
  function test1(){

    let cnt = 1;

    axios.get('/test1')
    .then(res => {
      console.log(3);
      console.log(res.data); //'test1'
      console.log(4);
    })
    .catch(error => console.log(error));

    console.log(cnt);
  }

  async function test2(){ // <- 앞에 async(함수)를 넣어주면 비동기방식으로 진행
    //await 명령어 사용 시 동기방식으로 진행
    let cnt = '';
    const res = await axios.get('/test1');
    cnt = res.data;
    console.log(cnt); //'test1'
  }

  function test3(){
    console.log(1);
    test2();
    console.log(2);
  }




  return (
    <div className="App">
      <div>
        <button type='button' onClick={()=>{test3}}>test1</button>
        <button type='button' onClick={()=>{getList()}}>test2</button>
      </div>
    </div>
  );
}

export default App;
