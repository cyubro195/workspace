import { useNavigate } from "react-router-dom";


const Item = ({item}) => {

  //navigate; = 변수
  //navigate(); = 함수

  //navigate(-1); -> 한 페이지 뒤로가기
  //navigate(-2); -> 두 페이지 뒤로가기
  //navigate( 1); -> 한 페이지 앞  가기

  const navigate = useNavigate();
       // ▲ 이친구는 함수입니다! 변수아님!     

  //const itemNum = item.itemNum;

  return (
    
    <div className='list1'>
      <img onClick={(e) => {
        navigate(`/detail/${item.itemNum}`);
      }} src={process.env.PUBLIC_URL + '/' + item.imgName} />
      <div className='banner-text'>
        <h3 onClick={(e) => {navigate(`/detail/${item.itemNum}`);}}>
          {item.itemName}
        </h3>
        <span> 내가 그린 그림은 김그린 </span>
        <p>{item.price}</p>
      </div>
    </div>

  );
}

export default Item;