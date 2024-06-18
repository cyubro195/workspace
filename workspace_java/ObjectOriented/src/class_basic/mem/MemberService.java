package class_basic.mem;

public class MemberService {
    //멤버 클래스 만들기 15번

    public boolean login(String id, String password){
        if(id.equals("hong") && password.equals("12345")){
            return true;
        }
        else {
            return false;
        }
    }

    public void logout(String id){
        System.out.println("로그아웃 되었습니다.");
    }

}
