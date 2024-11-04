import React, { useEffect, useState } from 'react'
import '../../reset.css'
import '../user/ItemDetail.css'
import axios from 'axios'
import { useNavigate, useParams } from 'react-router-dom'
import { FaShoppingCart } from "react-icons/fa";

const ItemDetail = ({}) => {
  const {itemCode} = useParams(); // 자바로 가져가야함

  const navigate = useNavigate();

  //조회한 정보정도 데이터를 저장할 state변수
  const [itemDetail , setItemDetail] = useState({});

  //대표 이미지명을 저장할 변수
  const [mainImgName, setMainImgName] = useState(''); // < 빈문자로 주기

  //상세 이미지명을 저장할 변수
  const [subImgName, setSubImgName] = useState('');

  // 수량을 저장할 변수
  const [itemCnt , setItemCnt] = useState(1);

  //총 가격을 저장하는 state변수
  const [totalPrice, setTotalPrice] = useState(0); // < 데이터 초기값 0을 넣어줘야함.

  //장바구니 담기버튼 클릭 시 -> 자바로 가져가는 데이터
  const [insertCartData, setInsertCartData] = useState({
    itemCode : itemCode , // <  위에 itmeCode값 가져온거영! 
    cartCnt : itemCnt , // 수량이라서 초기값은 1로 ㄱ 
    memId : JSON.parse(window.sessionStorage.getItem('loginInfo')).memId
  });

  //상품상세정보조회
  useEffect(()=>{
    axios.get(`/api_item/getItemDetail/${itemCode}`)
    .then((res)=>{
      console.log(res.data);

      //조회한 정보에서 대표이미지명, 서브이미지명 찾기
      let img1 = '';
      let img2 = '';
      res.data.imgList.forEach((img, i)=>{
        if(img.isMain == 'Y'){
          img1 = img.attachedFileName;
          // 왜 따로 변수로 주고 넣어주냐!?
          // state 값 때문에 재렌더링됨.
        }
        else{
          img2 = img.attachedFileName;
        }
      });
      setMainImgName(img1);
      setSubImgName(img2);
      setItemDetail(res.data);
      setTotalPrice(res.data.itemPrice);
    })
    .catch((error)=>{
      console.log(error);
    })
  },[]);

  //수량이 변경되는 실행되는 함수
  function changeItemCnt(e){
    const cnt = Number(e.target.value);
    
    //수량이 0이하이거나 10개를 초과하면 수량을 1로 고정
    if(cnt < 1 || cnt > 10 ){
      alert('수량은 최소 1개 , 최대 10개 입니다.')
      setItemCnt(1)
      setTotalPrice(itemDetail.itemPrice)

      //장바구니 등록, 필요한 수량의 데이터 변경
      setInsertCartData({...insertCartData, 'cartCnt' : 1});
    }else {

      // 총 가격 계산 : 단가 + 수량 
      // 단가 : itemDetail.itemPrice
      // 수량 : Number(e.target.value (input 입력한 글자)
      setTotalPrice(itemDetail.itemPrice * Number(e.target.value))
      setItemCnt(e.target.value);

      //장바구니 등록, 필요한 수량의 데이터 변경
      setInsertCartData({...insertCartData, 'cartCnt' : e.target.value});
    }
  }

  //장바구니
  function insertCart(){
    //insert
    axios.post('/api_cart/insert' , insertCartData)
    .then((res)=>{
      
      const result = window.confirm('장바구니에 상품을 담았습니다. \n 계속 쇼핑하겠습니까?');
      
      //취소를 선택하면 장바구니 목록 페이지로 이동
      if(!result){
        navigate('/cartList')
      }
    })
    .catch((error)=>{console.log(error)});
  }


  return (
    <div className='item-detail-div'>
      
      <div className='item-detail-intro1'></div>
      <div className='item-info-div'>
      
        <div className='item-img'>
          <img src = {`http://localhost:8080/upload/${mainImgName}`} />
        </div>

        <div className='item-name'>
          <h3>{itemDetail.itemName}</h3>
          <p>💰 판매가격 : { Object.keys(itemDetail).length == 0 ? '' : itemDetail.itemPrice.toLocaleString() + '원' }</p>
          <div>
            <span>수량</span>
            <input type='number' className='item-number' value={itemCnt} name='cartCnt'
            onChange={(e)=>{changeItemCnt(e)}}/>
          </div>
          <p>총 판매가격 : { Object.keys(itemDetail).length == 0 ? '' : '￦' + totalPrice.toLocaleString() + '원' }
          </p>

          <p>🚚 배송비 : 2500원</p>

          <div className='item-btn'>
            <button type='button'>구매하기</button>
            <button type='button' onClick={() => {insertCart()}}>장바구니 <FaShoppingCart /> </button>
          </div>
        </div>

      </div>
      <div className='item-detail-intro2'></div>

      <div className='item-intro-div'>
        <h2>작품소개</h2>
        <p>{itemDetail.itemIntro}</p>
      </div>

      <div className='item-detail'>
        <p className='item-detail-intro'>
          📌 출판사 제공 책소개
        </p>
        <img src={`http://localhost:8080/upload/${subImgName}`}/>
      </div>

    </div>
  )
}

export default ItemDetail