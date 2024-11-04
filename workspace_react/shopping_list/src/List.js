


function List(props){
  return (

    <div className='box'>
      <h3>장보기 목록</h3>
      {
        props.list.map((item, i) => {
          return (

            <div className="item-div" key={i}>
              <span className="item">{item}</span> 
              <button type="button" onClick={(e) => {
                props.list.splice(i, 1); //0번째부터 하나 지우겠습니다.
                 //props.list.splice(1,1); 1번째부터 하나 지우겠습니다.
                
                const copyList = [...props.list]; // 똑같은 배열을 또 한번 만들어주는것! 
                copyList.splice(i, 1);
                 
                // 위 아래 동일한 내용입니다...
                props.list.splice(i,1);
                props.setList([...props.list]);
                // 리스트에 있는값이 그대로 복사되면서 추가되는??뭐시기???

              }}>삭제</button>

            </div>
          );
        })
      }
    </div>


  );



}

export default List;