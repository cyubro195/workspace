import React, { useEffect, useState } from 'react'
import '../reset.css'
import './CarHome.css'
import axios from 'axios';

const CarHome = () => {

    //자동차 리스트 저장할 변수
    const [carList, setCarList] = useState([]);

    //차량목록 조회
    useEffect(()=>{
      axios.get('/api_car/carList')
      .then((res)=>{
        setCarList(res.data);
        console.log(res.data);
      })
      .catch((error)=>{
        console.log(error);
      })
    },[]);

  return (
    <div className='main-content'>

      <div className='intro-text'>
        <h3>차량 관리 시스템</h3>
      </div>
      <div className='car-table car-table-div'>
      <table>
        <colgroup>
          <col width='15%'/>
          <col width='*'/>
          <col width='15%'/>
        </colgroup>
        <thead>
          <tr>
            <td>모델번호</td>
            <td>모델명</td>
            <td>제조사</td>
          </tr>
        </thead>
        <tbody>
          {
            carList.map((car,i)=>{
              return (
                <tr key={i}>
                  <td>{i+1}</td>
                  <td>{car.carName}</td>
                  <td>{car.carBrand}</td>
                </tr>
              );
            })
          }
        </tbody>
      </table>
    </div>

    </div>
  )
}

export default CarHome