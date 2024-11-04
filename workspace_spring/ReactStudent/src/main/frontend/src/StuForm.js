import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { getStuDetail } from "./apis";
import { getStuUpdate } from "./apis";

const StuForm = () => {

  //버튼이동하게하기
  const navigate = useNavigate();

  //점수 정보를 변경할 학생의 기존 정보
  const [stuInfo, setStuInfo] = useState({});
  const {stuNum} = useParams();

  //업데이트 쿼리 실행 시 빈값을 가져가지 위한 변수
  const [stuGrd, setStuGrd] = useState({
    stuNum : 0,
    korScore : 0,
    engScore : 0,
    mathScore : 0
  });


  useEffect(()=>{

    getStuDetail(stuNum)
    .then((res) => {
      setStuGrd(res.data);
    })
    .catch((error) => {
      console.log(error);
      alert('님아! 오타확인하셈!');
    })
  },[]);


  function changeStuGrd(e){
    setStuGrd({
      ...stuGrd,
      [e.target.name] : e.target.value
    });
  }


  function stuForm(){
    getStuUpdate(stuGrd)
    .then((res)=>{
      console.log(res.data);
      alert('수정완료!');
      navigate('/stuList');
    })
    .catch((error) => {
      console.log(error);
      alert(' 오타 췎!!!! 루트 췍!!!');
    })
  }

  return(

    <div>
      <p>{stuInfo.stuName} 학생의 성적을 입력합니다.</p>

      <div>
        국어점수
        <input type="text" name="korScore" defaultValue={stuInfo.korScore} onChange={(e)=> {changeStuGrd(e)}}/> <br />
        영어점수
        <input type="text" name="engScore" defaultValue={stuInfo.engScore} onChange={(e)=> {changeStuGrd(e)}} /> <br />
        수학점수
        <input type="text" name="mathScore" defaultValue={stuInfo.mathScore} onChange={(e)=> {changeStuGrd(e)}} /> <br />
      </div>
      <button type="button" onClick={(e)=>{stuForm()}}>
        등록
      </button>
    </div>
  );

}

export default StuForm;