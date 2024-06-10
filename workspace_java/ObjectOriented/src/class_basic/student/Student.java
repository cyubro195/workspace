package class_basic.student;

//이름, 나이, 주소, 학번, 연락처
public class Student {

    private String name;
    private int age;
    private String addr;
    private int id;
    private int number;

    //생성자 초기화
    public Student(String name, int age, String addr,
    int id, int number){
        this.name = name;
        this.age = age;
        this.addr = addr;
        this.id = id;
        this.number = number;
    }

    // 변경하는 메소드 만들기
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setAddr(String addr){
        this.addr = addr;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setNumber(int number){
        this.number = number;
    }

    // 리턴하는 메소드 만들기

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddr(){
        return addr;
    }
    public int getId(){
        return id;
    }
    public int getNumber(){
        return number;
    }

    // 모든 변수의 값 출력하기
    public void printStudent(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + addr);
        System.out.println("학번 : " + id);
        System.out.println("폰번 : " + number);
    }




}
