
import React from 'react'
import { Link, NavLink, Outlet } from 'react-router-dom'

const UserLayout = () => {

  const activeStyle = {
    fontWeight : 'bold'
  };


  return (
    <div>
      <div className='menu-div'>
        <ul className='menu-ul'>
          <li>
            <NavLink to={'/'}>전체상품</NavLink>
          </li>
          <li>
            <NavLink to={'/'}> 인터넷/IT

            </NavLink>
          </li><li>
            <Link>소설</Link>
          </li><li>
            <Link to={'/'} >자기계발</Link>
          </li>
          <li>
            <NavLink to={'/'} style={({isActive}) => (isActive ? activeStyle : {})}>
              경제/경영
            </NavLink>
          </li>
        </ul>
      </div>
      <Outlet />
    </div>
  )
}

export default UserLayout