import axios from "axios";
import { useEffect, useState } from "react";
import { getStuList } from "./apis";

const StudentDelete = () => {

  //학생정보 가져오깅..
  const[stuList, setStuList] = useState([]);

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


  //삭제만들기!
  function stuDelete(stuNum){
    if(window.confirm(' 삭제하시겠슴까? ')){
      axios
      .delete(`/stuDelete/${stuNum}`)
      .then((res) => {
        alert('삭제 완료 ㅇ.< /★');

        // stuList 라는 state 변수의 값을 변경한다 -> 재랜더링되면서 알아서 그림 새롭게 그린다.
        // state 변수의 값을 state 변경함수를 사용해서 변경!

        //데이터베이스에서 삭제한 학생정보를 stuList에서도 삭제
        stuList.forEach((stu,i) => {
          if(stu.stuNum == stuNum){
            stuList.splice(i,1); //~몇번째 : i 를 1개 지운다는 뜻! 
          }
        });

        //stuList.filter(); > 조건에 맞는것만 돌려준다. 
        const result = stuList.filter((stu)=>{return stu.stuNum != stuNum});//제외하고 부른다 !=
                      //△ 여기 넣는걸 ~ 걸러낸다

        const arr =[1,2,3,4,5,6,7,8];
        const result1 = arr.filter((num) => {return num > 5}); //< 리턴 필수! 안그러면 오류남! 
        //const result2 = arr.filter((num)=>{num % 2 == 0});
        const result3 = arr.filter((num) => { return num > 5});
        
        setStuList([...result]);
      
      })
      .catch((error)=>{
        alert('삭제실패지롱!');
        console.log(error);
      })
    }
  }


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
                    <button type="button"onClick={(e)=>{stuDelete(stu.stuNum)}}>삭제</button>
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

export default StudentDelete;