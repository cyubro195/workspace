import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getStuDetail } from "./apis";

const StudentDetail = () => {

  const {stuNum} = useParams(); 
  const [stu, setStu] = useState([]);

  useEffect(()=>{
    getStuDetail(stuNum)
    .then((res) => {
      setStu(res.data);
    })
    .catch((error) => {
      console.log(error);
      alert('님아! 오타확인하셈!');
    })
  },[]);

  

  return(
    <div>
      <table>
          <tr>
            <td>이름</td>
            <td>{stu.stuName}</td>
            <td>나이</td>
            <td>{stu.stuAge}</td>
          </tr>
          <tr>
            <td>연락처</td>
            <td>{stu.stuTel}</td>
            <td>주소</td>
            <td>{stu.stuAddr}</td>
          </tr>
          <tr>
            <td>국어점수</td>
            <td>{stu.korScore}</td>
            <td>영어점수</td>
            <td>{stu.engScore}</td>
          </tr>
          <tr>
            <td>수학점수</td>
            <td>{stu.mathScore}</td>
            <td>평균</td>
            <td>
              {/* {
                 Math.round(stu.korScore + stu.engScore + stu.mathScore)/3) * 100)/100
              } */}

            </td>
          </tr>
      </table>
    </div>
  );
  

}
export default StudentDetail;