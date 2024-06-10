package class_basic.song;

// man 클래스 - 이름,나이,주소
public class Man {

    String name;
    int age;
    String adders;

    public void initMan(String name1, int age1, String adders1){
        name = name1;
        age = age1;
        adders = adders1;
    }
    public void printMan(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + adders);
    }




}
