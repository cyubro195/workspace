import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";




const StudentReg = () => {

  //이동하는거 만들기
  const navigate = useNavigate();
  //학생등록 쿼리 실행하기전 데이터 만들기!
  const [stuInfo, setStuInfo] = useState({
    stuName : '',
    stuAge  : '',
    stuTel  : '',
    stuAddr : ''
});

  function changeStuInfo(e){
    setStuInfo({
      ...stuInfo,
      [e.target.name] : e.target.value
    });
  }
  function StudentReg(){

    //이름 입력했는지 확인하기
    const nameInputTag = document.querySelector('input[name="stuName"]')
    if(nameInputTag.value == ''){
      alert('이름을 필수입력입니다!');
      nameInputTag.focus();
      return ; //> 더이상 진행하지않고 함수끝냄! 
    }

    // 이름 입력했는지 확인하기! 
    // 그 다음에 insert하셈!!!!
    axios
    .post('/insertStu', stuInfo)
    .then((res) => {
      alert('학생등록완!');
      navigate(`/stuList`);
    })
    .catch((error) => {
      console.log(error);
      alert('님아! 오타확인하셈!');
    })
  }

  return (
    <div>
      <h1> 학생등록 </h1>

      <div>
        이름 <input type="text" name="stuName" onChange={(e) => {changeStuInfo(e)}} />  <br />
        나이 <input type="text" name="stuAge" onChange={(e) => {changeStuInfo(e)}} />   <br />
        번호 <input type="text" name="stuTel" onChange={(e) => {changeStuInfo(e)}} />   <br />
        주소 <input type="text" name="stuAddr" onChange={(e) => {changeStuInfo(e)}} />  <br />
      </div>
      <button type="button" onClick={(e)=>{StudentReg()}}>학생등록</button>
    </div>
  );
}

export default StudentReg;