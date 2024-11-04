
import React, { useRef } from 'react'

const Modal = ({content, setIsShow}) => {
  const modalContainer = useRef();

  return (
    <div className='modal-container show' ref={modalContainer}>
      <div className='modal'>
        <div className='modal-header'>
          <span onClick={() => {
            modalContainer.current.className = 'modal-container';
            setTimeout(() => {
              setIsShow(false)
            }, 300);
          }}>
            <i className="bi bi-x-lg"></i>
          </span>
        </div>
        <div className='modal-content'>
          {
            content()
          }
        </div>
        <div className='modal-footer'>
          <button type='button' className='btn btn-primary'
            onClick={() => {
              modalContainer.current.className = 'modal-container';
              setTimeout(() => {
                setIsShow(false)
              }, 300);
            }}>확인</button>
        </div>
      </div>
    </div>
  )
}

export default Modal