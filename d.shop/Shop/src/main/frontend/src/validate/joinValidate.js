

//valid_tag[0] : memId
//valid_tag[1] : memName
export const joinValidate = (newData, valid_tag) => {
  //id가 영문만 포함 + 4~12자리인지 검사하는 정규식
  const regex_memId = /^[a-z|A-Z]{4,12}$/;

  //id 유효성 검사
  //test() : 매개변수로 들어온 데이터가 조건에 부합하면 리턴 true
  if(regex_memId.test(newData.memId)){
    sendFeedbackMsg(valid_tag[0], '사용 가능한 아이디입니다.', 'good');
  }
  else{
    sendFeedbackMsg(valid_tag[0], '불가능한 아이디입니다.', 'error');
  }

  // 이름 값 유효성 검사
  //정규식 : 2~10 글자 + 한글만
  const regex_memName = /^[ㄱ-ㅎ|가-힣]{2,10}$/;

  //정규식에 충족하면
  if(regex_memName.test(newData.memName)){
    sendFeedbackMsg(valid_tag[1], '사용 가능한 이름입니다.', 'good');
  }
  else{
    sendFeedbackMsg(valid_tag[1], '사용 불가능한 이름입니다.', 'error');
  }
}

//유효성 결과 메세지를 띄우는 함수
function sendFeedbackMsg(feedbackTag, msg, type){
  feedbackTag.current.className = `feedback ${type}`;
  feedbackTag.current.textContent = msg;
}