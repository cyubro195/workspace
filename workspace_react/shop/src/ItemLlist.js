

// 구식
// function item_list(){}

import Item from "./Item";

// 최신식.
          //똑같은애 넣어주면됨 그냥 외워!
const Item_List = ({item_list}) => {
  return (
    <div className='ba1'>
      {
        
        // map을 쓰는 이유는 리턴이 되기때문에 html에서 사용할수있음
        // 자바 리스트 반복문처럼!  
        item_list.map((item, i)=>{ //상품목록입니둥!
          return (
            <Item key={i} item = {item} />
          );
        })
      }  
    </div>
  );
}

export default Item_List;