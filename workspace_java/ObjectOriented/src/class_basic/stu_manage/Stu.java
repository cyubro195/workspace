package class_basic.stu_manage;

public class Stu {
    private String name;
    private int age;
    private String grade;
    private String tel;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getTel() {
        return tel;
    }

    public Stu(String name, int age, String grade, String tel) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.tel = tel;
    } // 매개변수로 생성자 만들기

    //학생의 모든 정보를 출력하는 기능
    public void showInfo(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("학점 : " + grade);
        System.out.println("연락처 : " + tel);
    }




}
