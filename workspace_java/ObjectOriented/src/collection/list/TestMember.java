package collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestMember {
    public static void main(String[] args) {

        //member 객체를 저장할 수 있는 list 객체 생성
        List<Member> memberList = new ArrayList<>();

        //멤버 만들기 3명
        Member m1 = new Member();
        m1.setId("java");
        m1.setPassword("1234");
        m1.setName("김자바");
        m1.setAge(20);
        Member m2 = new Member("python","1591","이파이",32);
        Member m3 = new Member("C++","2525","신프풀",40);

        //리스트에 저장할 데이터 만들기
        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);

        //목록리스트 전체출력하기!
        for ( Member test_member : memberList){
            System.out.println(test_member);
        }

        System.out.println();

        //7번풀기
        int sum = 0;
        for (int i = 0; i < memberList.size(); i++){
            sum = sum + memberList.get(i).getAge(); // 리스트에 저장된 회원 한명한명 나이빼기?
        }
        System.out.println("나이의 합 : " + sum);

        //8번풀기
        memberList.remove(1); //삭제해주세요 명렁어~
        int index = 0;
        for(int i = 0; i < memberList.size(); i++){
            if (memberList.get(i).getId().equals("java")) {
                index = i;
            }
        }
    }
}
