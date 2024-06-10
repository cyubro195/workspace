package class_basic;

public class StudentTest {
    public static void main(String[] args) { //실습하쟈ㅏㄱ!

        //학생 객체 stu1 생성
        Student stu1 = new Student();

        //stu1 이라는 학생의 이름을 출력
        System.out.println(stu1.name);

        //stu1 이라는 학생의 모든정보출력
        stu1.introduce();
        /////

        stu1.setName("kim");
        stu1.introduce();

        //방법들_둘 다 가넝!
        //stu1.age = 17; > 킹치만 이거 안쓰는게 좋뎅...ㅠ
        // 위에방법으로 쓰면 잘못된 데이터값을 막을수가없음.
        stu1.setAge(16); //< 이렇게 쓰는게 정석!
        // 애는 막을수있음


    }
}
