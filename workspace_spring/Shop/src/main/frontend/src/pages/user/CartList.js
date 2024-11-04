import React, { useEffect, useState } from 'react'
import '../user/CartList.css'
import axios from 'axios';
const CartList = () => {
// { } - 객체,한행 용 , [] - 리스트, 여러줄

  //장바구니 저장할 변수
  const [cartList, setCartList] = useState([]);

  // 조회한 장ㅂㅏ구니 목록 데이터를 저장할수있다
  const [chkAll, setChkAll] = useState(true);

  // 내용줄 안의 체크박스를 체크여부를 저장하고 있는 state변수
  const [chks, setChks] = useState([]);

  // const loginfo = JSON.parse(window.sessionStorage.getItem('loginInfo'));
  const memId = JSON.parse(window.sessionStorage.getItem('loginInfo')).memId;

  useEffect(()=>{
    axios.get(`/api_cart/getCartList/${memId}`)
    .then((res)=>{
      setCartList(res.data);

      //조회된 장바구니 목록만큼 체크박스의 값을 설정
      let checkArr = new Array(res.data.length); // < 배열을 만드는 새로운 
      //한방에 넣을수있는거
      checkArr.fill(true); // < 배열의 크기만큼 1로 다채움.
      setChks(checkArr);
    })
    .catch((error)=>{console.log(error)})
  },[]); // << 제발 빈박스 넣어라 ㅠ 


  useEffect(()=>{

    //마운트 됐을때는 실행하지 않겠다.
    if(chks.length != 0){
      //제목줄 체크 => 전체 체크
      const copyChks = [...chks];

      if(chkAll){
        copyChks.fill(true);
      }
      else {
        copyChks.fill(false);
      }

      setChks(copyChks);
    }
  },[chkAll]); // < 이거 왜 넣었냐면? 전체체크박스에 변경되면 재런더링되게 해줄려고!  

  //제목줄의 체크박스 변경 시 실행되는 함수
  function changeChkAll(){
    setChkAll(!chkAll);

  }

  console.log(cartList);
  return (
    <div className='cart-container'>
      <h2>🛒 장바구니 🛒</h2>
      <div className='cart-content'>
        <table className='cart-table'>
          <colgroup>
            <col width='*'/>
            <col width='*'/>
            <col width='60%'/>
            <col width='10%'/>
            <col width='*'/>
            <col width='10%'/>
            <col width='20%'/>
            <col width='*'/>
          </colgroup>
          <thead>
            <tr>
              <td>No</td>
              <td>
                <input type='checkbox' checked={chkAll} 
                onChange={()=>{ changeChkAll()}}  />
              </td>
              <td >상품정보</td>
              <td>가격</td>
              <td>수량</td>
              <td>구매가격</td>
              <td>구매일시</td>
              <td>삭제</td>
            </tr>
          </thead>
          <tbody>
            {
              cartList.map((cart,i)=>{
                return(
                  <tr key={i}>
                    <td>{cartList.length - i}</td>
                    <td>
                      <input type='checkbox' checked={chks[i]} onChange={()=>{
                        const copyChks = [...chks]; // 다른값 가져오는거
                        //const copyChks2 = chks; > 같은값 가져오는거 
                        copyChks[i] = !copyChks[i];
                        setChks(copyChks);
                      }} />
                      
                    </td>
                    <td className='img-td'>
                      <img src={`http://localhost:8080/upload/${cart.itemVO.imgList[0].attachedFileName}`} />
                      <span>{cart.itemVO.itemName}</span>
                    </td>
                    <td>{ '￦' + cart.itemVO.itemPrice.toLocaleString() + '원' }</td>
                    <td>
                      <input type='number' defaultValue={cart.cartCnt} />
                    </td>
                    <td> {(cart.itemVO.itemPrice * cart.cartCnt).toLocaleString()} </td>
                    <td>{cart.cartDate}</td>
                    <td>
                    <input type='button' value='삭제' />
                    </td>
                    
                  </tr>
                );
              })
            }
          </tbody>
        </table>
        <div className='totalcart'>
          <span>💰총 금 액</span>
        </div>
        <div>
          <button type='button'>삭제하기</button>
          <button type='button'>구매하기</button>
        </div>
      </div>
    </div>
  )
}

export default CartList