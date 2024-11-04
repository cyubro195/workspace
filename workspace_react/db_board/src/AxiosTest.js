import axios from "axios";


const AxiosTest = () => {

  //spring 서버와 데이터 통신을 위해 react에서는 axios 기술사용
  //axios설치 : npm install axios < 설치해야 데이터를 받아올수있음!

  //axios는 데이터베이스의 작업 종류에 따라 함수를 제공
  //get(url[, config]) < 대괄호는 필요할때만? : 데이터 함수를 조회할때 쓰는거(SELECT)
  //post(url, data[, config]) : 데이터 삽입(INSERT)
  //put(url, date [, config(생략가능)]) : 데이터 수정(UPDATE)
  //delete(url, [, config]) : 데이터 삭제(DELETE)

  /////////////////
  // 사용예제
  //axios.get()
  //.then(데이터 통신 성공 후 실행할 내용)
  //.catch(데이터 통신 중 오류 발생 시 실행);    < 위에서부터 한덩어리임! 

  //기본형태
  // axios
  // .get('/')
  // .then((res) => {}) < 통신한 모든 개체를 가지고 있는 애
  //         ▲ 변수명 아무거나 넣을수있음
  // .catch((error) => {});


  //버튼1 getTest
  //쿼리에 빈값이 없는 조회
  function get1(){
    axios
    .get('/getList')
    .then((res) => {
      console.log(res.data); //data뒤에 넣으면 data만 출력해서 볼수있음.
    })
    .catch((error) => {
      console.log('오류발생!!!!!!!!!!');
      console.log(error);
    });
  }


  //버튼2 post Test 
  function postTest(){
    axios
    .post('/insertBoard', {name:'kim', age:20})
                        // ▲ 객체
    .then((res)=>{})
    .catch((error)=>{})
  }


  //버튼3 put Test 
  function putTest(){
    axios
    .put( '/updateBoard' , {
      boardNum : 1,
      boardTitle : '자바',
      boardWriter : '길홍동'
    })
    .then((res) => {
      alert(' 수정완 ')
      alert(res.data); //< 여기에 데이터가 다 있음! 
    })
    .catch((error) => {})
  }

  function get2(){
    axios
    .get('/detail/1')
    .then((res) => {})
    .catch((error) => {});
  }

  return(
    <div>

      <h2>axios 통신연습</h2>

      <div className="btn-div">
        <button type="button" onClick={() => {get1()}}>
          get으로 데이터 조회하기 1
        </button>
      </div>

      <div className="btn-div">
        <button type="button" onClick={() => {get2()}}>
          get으로 데이터 조회하기 2
        </button>
      </div>   

      <div className="btn-div">
        <button type="button" onClick={() => {postTest()}}>
          post로 데이터 조회하기
        </button>
        </div>

      <div className="btn-div">
        <button type="button" onClick={() => {putTest()}}>
          put으로 데이터 조회하기
        </button>
      </div>

    </div>
  );
}



export default AxiosTest;