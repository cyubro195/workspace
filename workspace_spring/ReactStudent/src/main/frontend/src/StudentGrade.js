import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate} from "react-router-dom";
import { getStuList } from "./apis";


const StudentGrade = () => {


  //학생정보
  const [stuList, setStuList] = useState([]);
  const navigate = useNavigate();

  useEffect(()=>{

    getStuList()
    .then((res)=>{
      console.log(res.data);
      setStuList(res.data);
    })
    .catch((error)=>{
      console.log(error);
      alert('님아! 오타확인하셈!');
    })
  },[]);

  //수정하러가긩

  // function stuGrd(){
  //   if(window.confirm('수정하시겠습니까? °◦ε=ε=ε=(ง❀❛ ֊ ❛„)ว')){
  //     axios
  //     .put(`/stuUpdate`, stuList)
  //     .then((res)=>{
  //       alert('수정완료!! (՞ •̀֊•́՞)ฅ')
  //     })
  //     .catch((error)=>{
  //       alert('수정 실패!');
  //       console.log(error);
  //     })
  //   }
  // }

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
        {
          stuList.map((stu,i)=>{
            return(
              <tr key={i}>
                <td>{stuList.length - i}</td>
                <td>{stu.stuName}</td>
                <td>
                  <button type="button" onClick={() => {navigate(`/stuForm/${stu.stuNum}`);}}>
                    수정
                  </button>
                </td>
              </tr>
            );
          })
          }
        </tbody>
      </table>
    </div>
  );
}

export default StudentGrade;