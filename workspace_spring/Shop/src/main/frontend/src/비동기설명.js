import React from 'react'




  // 새로고침과 재랜더링은 다르다...!
  // 새로고침하면 state 변수의 값이 전부 초기화 된다.
  // 재 랜더링하면 state변수의 값은 보존된다!!!!

  // state 변경함수는 모든 코드가 실행 된 후 일관적으로 한 번에 처리
  // state 변경함수는 비동기 방식이기 때문에 주의!
const 비동기설명 = () => {

//동기 : 위에서부터 차례대로 한 줄의 코드가 완료되면 그 다음 코드를 진행
//비동기 : 위에서부터 차례대로 한 줄의 코드가 실행되면 그 다음 코드를 진행

// 비동기 처리를 위한 훅 : useState, useEffect 
// store 관리를 위한 redux :  useSelector
// 이런 비동기 처리를 그나마 편하게 하기 위해 제공하는 훅이 있는데 useState와 useEffect이다.

// useState
// 변수의 상태를 추척해준다 ** 추적이라는 단어가 매우 매우 중요하다.

// useEffect
// 변수의 상태를 추적해 뭔가를 하게 해준다. ** 추적이라는 단어가 매우 매우 중요하다.


// ------------ useState ----------------

//const [currentUser, setCurrentUser] = useState({});//< ({초기에 currentUser에 지정할 내용});

// 위와 같은 코드는 currentUser 라는 변수를 useState 로 관리한다는 뜻이고 useState가 제공하는 핵심 기능은 추적의 기능을 사용할 수 있어 currentUser라는 변수의 내용이 변하면 자동으로 jsx가 재 렌더링 되어 변화된 변수가 화면에 반영된다. 

//만약에 이렇게 useState 를 지정하지 않고 그냥 무작정

//const currentUser = "hello";

// 이런 식으로 변수를 설정하면 스크립트 내부에서 currentUser 변수에 변화가 있어도 jsx는 변수의 변화를 감지하지 못하기 때문에 어떻게 바뀌냐 얼마나 바뀌냐 언제 바뀌냐에 상관없이 그냥 hello라는 초기 상태만 표시하게 될 것이다.


// -------------- useEffect -------------------


useEffect(() => {
    const load = async () => {
      try {
        if (user !== undefined) {
          setCurrentUser(user);
        }
      } catch (error) {
        console.log("하하");
      }
    };
    load();
    console.log("Hello");
  }, [user]);

// useState와 비슷한 기능의 훅인데 useState는 변수를 추척해 변화가 생긴다면 재 렌더링 하는 기능이라면 useEffect는 변수를 추적해 변화가 생기면 어떠한 기능을 수행할 수 있게 해 준다.

// 생김새를 보면,

// useEffect(() => {{개발자가 꿈을 펼침}}, [추척할 변수 지정]);

// 위 코드에 해석하면 user라는 변수를 추적해서 → [추적할 변수 지정]
// 이 변수에 변화가 생길 때마다 load() 를 실행한다 → {개발자가 꿈을 펼침}

// 리액트로 코드를 짤 때 변수에 대한 비동기 처리는 useState 와 useEffect와 같은 막강한 hook을 써서 정말 편하게 할 수 있다.

  return (
    <div>
      동기와 비동기 개념잡기
    </div>
  )
}

export default 비동기설명