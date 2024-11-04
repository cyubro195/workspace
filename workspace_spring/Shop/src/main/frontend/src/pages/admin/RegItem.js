import React, { useEffect, useState } from 'react'
import './RegItem.css'
import axios from 'axios';
import Modal from '../../common/Modal';
import { json, useNavigate } from 'react-router-dom';

const RegItem = (setItemInfo, itemInfo) => {

  //첨부파일을 저장할 start 변수만들기~
  const [mainImg, setMainImg] = useState(null);
  const [ subImg, setSubImg ] = useState(null);

  //카테고리 목록을 저장할 state 변수
  const [categoryList , setCategoryList] = useState([]);

  //상품등록 클릭 시 화면에 보여지는 모달창
  const [beforeItemModal, setBeforeItemModal] = useState(false);

  //상품등록 후 보여지는 모달창
  const [afterItemModal, setAfterItemModal] = useState(false);

  //상품등록 실패시 보여지는 함수
  const [isItemSuccess, setItemSuccess] = useState(false);

  //이동
  const navigate = useNavigate();

  //빈값 넣어주는 곳..
  const [insertItemData , setInsertItemData] = useState({
    cateCode : 1,
    itemName : '',
    itemPrice : '',
    itemIntro : '',
  });

    //카테고리 목록 조회
    useEffect(()=>{
      axios.get('/api_admin/getCateList')
      .then((res)=>{
        setCategoryList(res.data);
        console.log(res.data);
      })
      .catch((error)=>{
        console.log(error);
      })
    },[]);

  //input에 입력값 넣어주기
  function changeItemData(e){
    setInsertItemData({
      ...insertItemData,
      [e.target.name] : e.target.value
    })
  }
console.log(insertItemData);


  // 📌등록버튼 클릭 시 실행
  function insertItem(){
    //axios 통신으로 자바로 갈 때 첨부파일이 있으면 반드시 아래의 설정코드를 axios에 추가..반둣ㅇ...
    const fileConfig = {headers : {'Content-Type' : 'multipart/form-data'}}
    //등록 입력여부 확인
    if(insertItemData.itemName == '' || insertItemData.itemPrice == ''){
      setBeforeItemModal(true);
    }
    //위의 설정코드를 axios 통신할 때 추가하면 자바로 넘어가는 데이터를 전달하는 방식이 달라짐.
    //첨부파일이 있는 데이터를 자바로 전달하기 위해서는 form태그를 사용해서 전달!

    // 1. form 객체생성 [원래 자바스크립트에서 쓰던겅]
    const itemForm = new FormData();

    // 2. form 객체에 데이터 추가
    // itemForm.append('itemName','상품1');
    // itemForm.append('itemPrice',10000);

    itemForm.append('itemName', insertItemData.itemName); 
    itemForm.append('itemPrice', insertItemData.itemPrice); 
    itemForm.append('itemIntro', insertItemData.itemIntro); 
    itemForm.append('cateCode', insertItemData.cateCode); 
    itemForm.append('mainImg', mainImg); //첨부파일정보
    itemForm.append('subImg', subImg);

    //3. 데이터를 가진 form 객체를 axios 통신에서 자바로 전달한다.
    //axios.post('/api_admin/insertItem',insertItemData,fileConfig)

    axios.post('/api_admin/insertItem', itemForm, fileConfig)
    .then((res)=>{
      setAfterItemModal(true);
      alert('등록완!')
      console.log(itemForm);
      //자바에서 받기
      if(res.data == '' ){ //상품등록 실패할때
        setItemSuccess(false);
      }
      else{
        setItemSuccess(true)

        //상품정보는 여기
        const itemInfo = {
          cateCode : res.data.cateCode,
          itemName : res.data.itemName,
          itemPrice : res.data.itemPrice,
          itemIntro : res.data.itemIntro
        };

        const json_itemInfo = JSON.stringify(itemInfo);

        window.sessionStorage.setItem(
          'itemInfo',json_itemInfo);

        setItemInfo(itemInfo);
      }
    })

    .catch((error)=>{console.log(error)})
  }

  // 상품등록 후 뜨는 모달창
  function drawModalContent(){
    return (
      <>
      {
        isItemSuccess
        ?
        <div>
          🎉상품등록이 완료되었습니다🎉
        </div>
        :
        <div>
          ㅠㅠ다시확인ㅠㅠ
        </div>
      }
      </>
    );
  }

  //상품등록 확인버튼 누를때
  function uploadBtn(){
    if(isItemSuccess){
      navigate('/admin/regItem');
    }
  }





  return (
    <div className='reg-container'>
      <div className='update-book'>
        <span>✨</span> 
        <h2>U P D A T E - B O O K</h2>
        <span>✨</span>
      </div>
      <div className='regitem'>
        <div>
          <p className='item-text'>📕 상품 카테고리 <span>(필수)</span>  </p>
          <select className='text-item' name='cateCode' onChange={(e)=>{changeItemData(e)}}>
            {
              categoryList.map((category,i) => {
                return(
                  <option key={i} value={category.cateCode}>{category.cateName}</option>
                );
              })
            }
          </select>
        </div>
        <div className='category-box'>
          <p className='item-text' >🎀 상품명 <span>(필수)</span></p>
          <div>
            <input type='text' name='itemName' className='text-item' onChange={(e)=>{changeItemData(e)}} />
          </div>
        </div>
        <div>
          <p className='item-text'>💸 상품가격 <span>(필수)</span> </p>
          <div>
            <input type='text' name='itemPrice'className='text-item' onChange={(e)=>{changeItemData(e)}} />
          </div>
        </div>
        <div>
          <p className='item-text'>📌 상품소개</p>
          <div>
            <textarea className='textarea-item' name='itemIntro' onChange={(e)=>{changeItemData(e)}} />
          </div>
        </div>
        <div className='uploadfile-box'>
          {/* multiple : 파일을 여러개 선택해서 올릴수있음 */}
          <input type='file' onChange={(e)=>{
            //선택한 파일정보(배열형태로 가져옴)
            console.log(e.target.files[0]); //배열형태이기 때문에 배열로 넣어주는거 ㅜ
            setMainImg(e.target.files[0]);
          }} />
        </div>
        <div className='uploadfile-box'>
          <input type='file' onChange={(e)=>{
            setSubImg(e.target.files[0]); // << 파일정보 알려주기 
          }} />
        </div>
      </div>
      <button type='button' className='btn itembtn' onClick={()=>{insertItem()}}>상품등록</button>


      {/* 상품등록 입력여부 모달창 */}
      {
        beforeItemModal
        ?
        <Modal  content = {() => {
            return (
              <div>📌필수입력을 확인해주세요!</div>);
            }}
          setIsShow = {setBeforeItemModal}
          clickModalBtn = {()=>{setBeforeItemModal(false)}}/>
        :
        null
      }

      {/* 상품등록 완료 모달창 */}
      
      {
        afterItemModal
        ?
        <Modal content={drawModalContent}
        setIsShow={setAfterItemModal}
        clickModalBtn={uploadBtn} />
        :
        null
      }

    </div>
  )
}


export default RegItem