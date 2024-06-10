package class_basic.man;

public class Man {
    //이름, 나이, 주소
    private String name;
    private int age;
    private String addr;

    // 생성자로 초기화하기
    // 모든 값을 변경할 수 있는 생성자
    public Man(String name, int age, String addr){
        this.name = name;
        this.age = age;
        this.addr = addr;
    }


    // setter : 멤버변수 각각의 값을 변경하는 메서드 (**매우 중요**)
    // setter 의 이름은 set 변수명으로 반드시 지정!


    // 3. 멤버 각각의 값을 변경하는 메소드를 3개
    // 이름을 변경하는 메소드 만들기
    public void setName(String name){ // << setter : set+대문자필수
        this.name = name;
    }
    // 나이을 변경하는 메소드 만들기
    public void setAge(int age){
        this.age = age;
    }
    // 주소을 변경하는 메소드 만들기
    public void setAddr(String addr){
        this.addr = addr;
    }

    //4. 각 멤버의 값을 리턴 하는 메소드를 3개 풀이.

    //getter : 멤버변수 각각의 값을 return 받는 메서드
    //getter 의 이름은 get 변수명으로 반드시 지정! get+대문자


    //이름을 리턴하는 메서드
    public String getName(){
        return name;
    }
    //나이을 리턴하는 메서드
    public int getAge(){
        return age;
    }
    //주소를 리턴하는 메서드
    public String getAddr(){
        return addr;
    }

    // 모든 변수의 값 출력하기
    public void printMan(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + addr);
    }

}
