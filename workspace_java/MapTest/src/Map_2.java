import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_2 {
    public static void main(String[] args) {
        // 학생 객체 3명 생성 후
        // 3명의 학생을 map에 저장하시오
        // 이때 키는 각 학생의 학번으로 저장합니다.

        Student stu1 = new Student(1,"김자바");
        Student stu2 = new Student(2,"박자바");
        Student stu3 = new Student(3,"최자바");
                    // ▼ 학생자료형
        Map<Integer, Student> stuMap = new HashMap<>();
        stuMap.put(stu1.getStuNum(),stu1);
        stuMap.put(stu2.getStuNum(),stu2);
        stuMap.put(stu3.getStuNum(),stu3);


        //키가 2번인 학생의 학생이름 출력
        stuMap.get(2).getStuName();




    }


}
