package class_basic;

public class Student {

    String name;
    int age;
    int score;
    // 밑에서 써도 인식됨! main 메소드에서만 위에서 아래로 지키기!

    //매개변수로 전달된 문자열을 name 값을 변경
    public void setName(String name1){
        name = name1;

    }
    // 나이를 변경하는 메소드를 만드세용 > 매개변수로 활용쓰~
    public void setAge(int a){
        age = a;
    }


    public void introduce(){
        System.out.println("이름 : " + name); // 중괄호안에서라서 다됨!!
        System.out.println("나이 : " + age);
        System.out.println("점수 : " + score);
    }
}
