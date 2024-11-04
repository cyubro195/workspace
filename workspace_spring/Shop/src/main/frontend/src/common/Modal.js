
import React, { useRef } from 'react'
import { useNavigate } from 'react-router-dom';

// content : 모달에서 보여지는 내용
// setIsShow : 모달을 닫는코드
// clickModalBtn : 모달의 확인버튼 클릭시 실행할 코드.

const Modal = ({content, setIsShow, clickCloseBtn}) => {
  
  const navigate = useNavigate();
  const modalContainer = useRef();

  return (
    
    <div className='modal-container show' ref={modalContainer}>
      <div className='modal'>
        <div className='modal-header'>
          <span onClick={()=>{
            modalContainer.current.className = 'modal-container';
            setTimeout(() => {
              setIsShow(false)
              clickCloseBtn()
            },300);
          }}>
            <i className="bi bi-x-circle-fill"></i>
          </span>

        </div>

        <div className='modal-content'>
          {
            content()
          }
        </div>

        <div className='modal-footer'>
          <button type='button' className='btn' 
          onClick={()=>{ modalContainer.current.className = 'modal-container'
          setTimeout(() => {
            
            //모달창 닫기
            setIsShow(false)
            //어떤 페이지에서 모델창을 실행했냐에 따라 실행코드가 달라져야함!
            clickCloseBtn();

            },300);}}>
            확인
          </button>
        </div> 
      </div>
    </div>
  );
}

export default Modal