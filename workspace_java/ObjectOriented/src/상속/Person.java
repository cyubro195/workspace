package 상속;

public class Person{
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void dispalyInfo(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("성별 : " + gender);
    }
}





