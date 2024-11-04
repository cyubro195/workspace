import React, { useEffect, useState } from 'react'
import '../reset.css'
import './CarList.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const CarList = () => {


  //자동차 리스트 저장할 변수
  const [carList, setCarList] = useState([]);

  const navigate = useNavigate();

  //자동차 등록
  const [ insertCarData , setInsertCarData ] = useState({
    carName : '',
    carPrice : '',
    carBrand : ''
  });


  //자동차 등록 input 입력값 넣어주기
  function changeCarData(e){
    setInsertCarData({
      ...insertCarData,
      [e.target.name] : e.target.value
    });
  }

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


  //등록버튼
  function insertCar(){
  axios
    .post('/api_car/insertCar', insertCarData)
    .then((res)=>{
      console.log(res)
        if (window.confirm("등록 하시겠습니까??(ﾟДﾟ*)ﾉ")) {
          alert("등록되었습니다!👀✨");
      } else {
          alert("등록을 취소합니다😢");
      }
      navigate('/')
    })
    .catch((error)=>{console.log(error);})
  }

  console.log(insertCarData);

  return (
  <div className='container'>

    <div className='carcontent'>
      <div className='intro-text'>
        <h3>차량 등록</h3>
      </div>

      <div className='car-sub'>
        <div className='car-sub-div'>
          <p>제조사</p>
          <select className='car-brand' name='carBrand' onChange={(e)=>{changeCarData(e)}}>
            <option>현대</option>
            <option>기아</option>
            <option>쌍용</option>
          </select>
        </div>

        <div className='car-sub-div'>
          <p className='car-name'>모델명</p>
          <input type='text' name='carName' className='car-input' onChange={(e)=>{changeCarData(e)}} />
        </div>

        <div className='car-sub-div'>
          <p className='car-name'>차량가격</p>
          <input type='text' name='carPrice' className='car-input' onChange={(e)=>{changeCarData(e)}} />
        </div>

      <button type='button' className='btn' onClick={()=>{insertCar()}}>
          등록
      </button>
    </div>
    
    

    </div>

    <div className='car-table'>
      <table>
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

export default CarList