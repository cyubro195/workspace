package collection.list;

public class Member {

    // 아이디, 비밀번호, 이름, 나이
    private String id;
    private String password;
    private String name;
    private int age;

    public Member(){} // 오류 사라지게 할려고 셋팅해줘야함!
    public Member(String id, String password, String name, int age) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    // getter 만들기
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setter 만들기

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
