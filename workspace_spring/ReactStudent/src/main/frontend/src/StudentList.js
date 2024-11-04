import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import './StudentList.css'
import { getStuList } from "./apis";
// 위에꺼 필요한것만 가져올려면 이렇게 활용하면됨!!
// import {stuList} from './apis';



const StudentList = () => {

  const navigate = useNavigate();     //  ▼ [] : 배열 , {} : 객체 초기값 
  const [stuList, setStuList] = useState([]);
                                        //▲ 배열에는 배열 객체는 객체

  useEffect(() => {
    getStuList()
    .then((res) => {
      console.log(res.data);
      setStuList(res.data);
    })
    .catch((error) => {
      console.log(error);
      alert('님아! 오타확인하셈!');
    });
  },[]);

  return (

    <div className="stulist_t">

      <h1> 학생리스트 </h1>

      <div className="stulist_tb">

        <table>

          <thead>
            <tr>
              <td>No</td>
              <td>학생명</td>
              <td>국어점수</td>
              <td>영어점수</td>
              <td>수학점수</td>
              <td>평균</td>
            </tr>
          </thead>

          <tbody>
            { 
              stuList.length == 0 ?
              <tr>
                <td colSpan='6'>조회된 데이터가 없습니다.</td>
              </tr>
              :

              stuList.map((stu,i)=>{
                const avg = (stu.korScore + stu.engScore + stu.mathScore)/3;
                return(
                  <tr key={i}>
                    <td>{i+1}</td>
                    {/* 순서 역순으로 하는방법 : {stuList.length - i}  */}
                    <td>
                      <span onClick={()=>{
                        navigate(`/detail/${stu.stuNum}`);
                      }}>
                        {stu.stuName}
                      </span>
                    </td>
                    <td>{stu.korScore}</td>
                    <td>{stu.engScore}</td>
                    <td>{stu.mathScore}</td>
                    <td>{Math.round( avg * 100 ) / 100}</td>

                    {/* {Math.round(1.7555*100)/100} - 이런형식으로 해서 평균을 구해줘야함 ㅎ */}
                    
                  </tr>
                );
              })
            }
          </tbody>

        </table>

      </div>

    </div>
  );
}

export default StudentList;