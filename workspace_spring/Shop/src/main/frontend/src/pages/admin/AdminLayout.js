import React, { useState } from 'react'
import { Link, Outlet } from 'react-router-dom'
import { CiCirclePlus } from "react-icons/ci";


const AdminLayout = () => {
  

  //사이드 메뉴 정보를 관리하는 state변수
  const [sideMenu, setSideMenu] = useState('itemManage');


  //사이드 메뉴를 화면에 그리는 함수
  function drawSideMenu(){
    // 상단메뉴에서 상품관리 클릭 시
    if(sideMenu == 'itemManage'){
      return (
        <>
          <li>
            <Link to="/admin/plusItem">상품관리</Link>
          </li>
          
          <li>
            <Link to="/admin/regItem">상품등록</Link>
            {/* <CiCirclePlus className='sub-icon' /> */}
          </li>
          
          <li>
            <Link to="/admin/regItem">카테코리 관리</Link>
          </li>
        </> 
      );
    }
    // 상단메뉴에서 구매관리 클릭 시
    else if(sideMenu == 'saleManage'){
      return(
        <>
          <li>
            <Link> 이달의 구매내역 </Link>
          </li>
          <li>
            <Link to="/admin/regItem">구매정보 검색</Link>
            <CiCirclePlus className='sub-icon' />
          </li>
          <li> <Link>카테코리 관리</Link></li>
        </> 
      );
    }
    // 상단메뉴에서 유저관리 클릭 시
    else if(sideMenu == 'userManage'){
      return(
        <>
          <li>
            <Link> 유저 검색 </Link>
          </li>
          <li>
            <Link to="/admin/regItem">유저정보변경</Link>
            <CiCirclePlus className='sub-icon' />
          </li>
          <li> <Link>탈퇴유저관리</Link></li>
        </> 
      );
    }
    // 상단메뉴에서 매출관리 클릭 시
    else if(sideMenu == 'recordManage'){
      return(
        <>
          <li>
            <Link> 이달의 매출 </Link>
          </li>
          <li>
            <Link to="/admin/regItem">월별매출</Link>
            <CiCirclePlus className='sub-icon' />
          </li>
          <li> <Link>카테코리별 매출</Link></li>
        </> 
      );
    }
  }
  return (
    <div>
      <div className='menu-div'>
        <ul className='menu-ul'>

          <li>
            <Link to="/admin/regItem" onClick={()=>{setSideMenu('itemManage')}} >상품관리</Link>
          </li>

          <li>
            <Link onClick={()=>{setSideMenu('saleManage')}} >구매관리 </Link>
          </li>

          <li>
            <Link to='plusItem' onClick={()=>{setSideMenu('userManage')}} >유저관리 </Link>
          </li>

          <li>
            <Link onClick={()=>{setSideMenu('recordManage')}} >매출관리 </Link>
          </li>

        </ul>
      </div>

      <div className='side-menu'>
          <ul className='sidenav'>
            {
              drawSideMenu()
            }
          </ul>  
          <Outlet />
          <div className='side-menu-bar2'></div>
      </div>
      
    </div>
  )
}






export default AdminLayout