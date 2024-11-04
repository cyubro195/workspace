import axios from "axios"



//아이디 중복체크
export const checkId = (data) =>{
  const response = axios.get(`/api_member/checkId/${data}`);
  return response;
}