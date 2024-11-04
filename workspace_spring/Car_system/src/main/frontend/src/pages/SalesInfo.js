import React, { useEffect, useState } from 'react'
import '../reset.css'
import './SalesInfo.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SalesInfo = () => {

  const navigate = useNavigate();

  //차량모델조회
  const [modelList, setModelList] = useState([]);

  //판매자 등록
  const [insertBuyer , setInsertBuyer] = useState({
    buyer : '',
    color : '',
    carNum : 1,
    buyerTel : ''
  });

  useEffect(()=>{
    axios.get('/api_car/carModel')
    .then((res)=>{
      setModelList(res.data)
    })
    .catch((error)=>{
      console.log(error);
    })
  },[]);

  //구매자 등록입력값 넣어주기
  function changeSalesData(e){
    setInsertBuyer({
      ...insertBuyer,
      [e.target.name] : e.target.value
    });
  };

  // 구매자등록버튼
  function insertSales(){
    axios.post('/api_sales/insertSales', insertBuyer)
    .then((res)=>{
      console.log(res.data)
      alert('등록완료')
      navigate('/salesList')
    })
    .catch((error)=>{
      console.log(error);
      alert('등록실패!')
    })
  }
  console.log(insertBuyer);

  return (
    <div className='sale-content'>
      <div className='intro-text'>
        <h3>판매정보 등록</h3>
      </div>
      <div>
        <table className='sale-table'>
          <colgroup>
            <col width='10%'/>
            <col width='*'/>
            <col width='*'/>
          </colgroup>
            <tr>
              <td>구매자명</td>
              <td colSpan='3'><input type='text' className='sale-input' name='buyer' onChange={(e)=>{changeSalesData(e)}}/></td>
            </tr>
            <tr>
              <td>색상</td>
              <td>
                <select className='car-brand' name='color' onChange={(e)=>{changeSalesData(e)}}>
                  <option>블랙</option>
                  <option>화이트</option>
                  <option>실버</option>
                  <option>레드</option>
                </select>
              </td>
              <td>모델</td>
              <td>
                <select className='car-brand' name='carNum' onChange={(e)=>{changeSalesData(e)}}>
                  {
                    modelList.map((model,i)=>{
                      return(
                        <option value={model.carNum}>{model.carName}</option>
                      );
                    })
                  }
                </select>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td colSpan='3'>
                <input type='text' className='sale-input' name='buyerTel' onChange={(e)=>{changeSalesData(e)}} />
              </td>
            </tr>
        </table>
        <button type='button' className='btn btn1' onClick={()=>{insertSales()}}>등록</button>
      </div>
    </div>
  )
}

export default SalesInfo