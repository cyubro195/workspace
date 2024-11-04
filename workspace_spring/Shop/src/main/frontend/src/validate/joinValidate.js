


//유효성 검사결과를 저장할 변수
//▼ 안에 넣어놓으면 계속 반복되기때문에 이런친구들은 밖에 내보내야함
let resultArr = [
  false, // 아이디 
  false, // 비번
  false, // 이름
  false, // 연락처
];

let result_pw1 = false;
let result_pw2 = false;



export const joinValidate = (newData, valid_tag, tagName) => {
                               // ▲ 이친구들은 저쪽 데이터를 매개변수로 받아오면됨! 

// input창에 각각 뜨게하는 방법 
  switch(tagName){

    // ✨ID의 값을 변경했으면 id의 패드백만 띄운다.
    case 'memId' :
      //id가 영문만 포함+ 4에서 12자리인지 검사하는 정규식
      const regex_memId = /^[a-z|A-Z]{4,12}$/;

      //test() : 매개변수로 들어온 데이터가 조건에 부합하면 리턴 true
      if(regex_memId.test(newData.memId)){
        sendFeedbackMsg(valid_tag[0],'사용 가능한 아이디! (´｡• ◡ •｡`) ♡', 'good');
        resultArr[0] = true;
      }
      else{
        sendFeedbackMsg(valid_tag[0],'사용 불가능 아이디! Σ(； ･`д･´)', 'error');
        resultArr[0] = false;
      }
    break;
    
    // ✨PW의 값을 변경했으면 pw의 패드백만 띄운다.
    case 'memPw':
    case 'confirmPw' :

    // 4~12 글자, 영문 소문자 + 숫자
    const regex_memPw = /^(?=.*[a-z])(?=.*[0-9]).{4,12}$/


    if(regex_memPw.test(newData.memPw)){
      sendFeedbackMsg(valid_tag[1],'(｡•̀ᴗ-)✧','good');
      result_pw1 = true;
    }
    else{
      sendFeedbackMsg(valid_tag[1], 'no','error')
      result_pw1 = false;
    }

    // 입력한 두 비번이 다르면???
    if(newData.memPw != newData.confirmPw){
      sendFeedbackMsg(valid_tag[2],'일치하지않습니다','error')
      result_pw2 = false;
    }
    else{
      sendFeedbackMsg(valid_tag[2],'(｡•̀ᴗ-)✧','good')
      result_pw2 = true;
    }

    //결과는??
    resultArr[1] = result_pw1 && result_pw2 ? true : false;
    
    break;
      

    // ✨Name의 값을 변경했으면 name의 패드백만 띄운다.
    case 'memName' :
    
      //한글만 가능한 정규식
      const regex_memName = /^[ㄱ-ㅎ|가-힣]{2,10}$/;
                                    // ▲ 한글 2~10글자
      if(regex_memName.test(newData.memName)){
      sendFeedbackMsg(valid_tag[3],'사용이 가능한 이름이예요!(*ˊᵕˋ*)', 'good');
      resultArr[2] = true;
      }
      else{
      sendFeedbackMsg(valid_tag[3],'사용이 불가능한 이름이예요!＼(´◓Д◔`)／', 'error');
      resultArr[2] = false;
      }

      break;
    
    // ✨Tel의 값을 변경했으면 tel의 패드백만 띄운다.
    case 'memTel' :
      const regex_memTel = /^\d{2,3}-\d{3,4}-\d{4}$/;

      if(regex_memTel.test(newData.memTel)){
        sendFeedbackMsg(valid_tag[4], '유요한 연락처입니다', 'good')
        resultArr[3] = true;
      }
      else{
        sendFeedbackMsg(valid_tag[4], '유요하지 않는 연락처입니다', 'error')
        resultArr[3] = false;
      }

      break;
  }
  console.log(resultArr);

  // 마지막 최종리턴 
  // resultArr의 모든 데이터가 true일때만 리턴 true

  // 배열에 매개변수로 전달된 데이터가 존재하면 리턴 true;
  return !resultArr.includes(false); //< 여기 데이터에 false가 포함되어 있냐? ㄹㅏ는 질문임.
  
  // ▽ 자매품 ▽ : 다른버전
  // for(const e of resultArr){ //true true false false
  //   if(!e){
  //     return false;
  //   }
  // }

  // return true;

}

  //유효성 결과 메세지를 띄우는 함수
  function sendFeedbackMsg(feedbackTag, msg, type){
    feedbackTag.current.className = `feedback ${type}`;
    feedbackTag.current.textContent = msg;
  }


