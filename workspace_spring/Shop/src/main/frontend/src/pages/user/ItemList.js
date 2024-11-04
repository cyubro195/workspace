import React, { useEffect, useState } from 'react'
import '../../reset.css'
import '../user/ItemList.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ItemList = () => {

  //상품목록을 저장할 변수
  const [itemList, setItemList] = useState([]);

  const navigate = useNavigate();

  //상품 목록 조회
  useEffect(()=>{
    axios.get('/api_item/itemList')
    .then((res)=>{
      setItemList(res.data);
    })
    .catch((error)=>{
      console.log(error);
    })
  },[]);


  //가져온 페이지 정보를 담을 변수
  const [listInfo, setListInfo] = useState({});


  console.log(itemList);
  // itemList[0].imgList[0].attachedFileName < 이런식으로 이미지를 불러오면 되는형식인데...흠..

  return (

    <div className='item-list-div'>
      {
        itemList.map((item,i)=>{
          return(
            <div className='item-div' key={i} onClick={()=>{
              navigate(`/itemDetail/${item.itemCode}`)
            }}>
              <img src={`http://localhost:8080/upload/${item.imgList[0].attachedFileName}`} />
              <h4>{item.itemName}</h4>
              
              <p>{ '￦' + item.itemPrice.toLocaleString() + '원' }</p>
            </div>
          );
        })
      }

    </div>
  )
}

export default ItemList