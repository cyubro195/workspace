package class_basic.member;

// 회원정보 이름, 아이디, 비밀번호, 나이
public class Member {

    String name;
    String id;
    String password;
    int age;
/*

    //회원정보 메소드 넣기
    public void setName(String a){
        name = a;
    }
    public void setId(String b){
        id = b;
    }
    public void setPassword(String c){
        password = c;
    }
    public void setAge(int d){
        age = d;
    }
*/

/*
    //회원정보 속성출력
    public void printMemberInfo(){
        System.out.println("이름 : " + name);
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + password);
        System.out.println("나이 : " + age);
    }

*/

    //4개의 변수값을 모두 변경하는 메서드 1개

    public void setMemberInfo(String name1, String id1,String password1,int age1){
        name = name1;
        id = id1;
        password = password1;
        age = age1;

    }

    public void printMemberInfo(){
        System.out.println("이름 : " + name);
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + password);
        System.out.println("나이 : " + age);
    }



}
