import React, { useEffect, useState } from 'react'
import '../reset.css'
import './SalesList.css'
import axios from 'axios';

const SalesList = () => {

  const [salesList, setSalesList] = useState([]);

  //구매자님덜 목록 조회
  useEffect(()=>{
    axios.get('/api_sales/getBuyList')
    .then((res)=>{
      setSalesList(res.data);
      console.log(res.data);
    })
    .catch((error)=>{
      console.log(error);
    })
  },[]);

  return (
  <div className='m-content'>
    <div className='intro-text'>
      <h3>판매자 등록</h3>
    </div>
    <table className='car-table'>
      <thead>
        <tr>
          <td rowSpan={2}>No.</td>
          <td colSpan={4}>구매자 정보</td>
          <td colSpan={2}>차량 정보</td>
        </tr>
        <tr>
          <td>구매자명</td>
          <td>연락처</td>
          <td>구매일</td>
          <td>색상</td>
          <td>모델명</td>
          <td>가격</td>
        </tr>
      </thead>
      <tbody>
        {
          salesList.map((sale,i)=>{
            return(
              <tr key={i}>
                <td>{i+1}</td>
                <td>{sale.buyer}</td>
                <td>{sale.buyerTel}</td>
                <td>{sale.buyDate}</td>
                <td>{sale.color}</td>
                {sale.carInfo.map(car => (
                  <>
                    <td>{car.carName}</td>
                    <td>{car.carPrice}</td>
                  </>
                    ))}
              </tr>
            );
          })
        }
      </tbody>
    </table>
  </div>
  )
}

export default SalesList