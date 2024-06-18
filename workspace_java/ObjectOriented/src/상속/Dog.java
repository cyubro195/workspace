package 상속;

import java.sql.SQLOutput;

//우리 병원에는 강아지,고양이,송아지 3종류의 동물관리
//병원에는 총 10개의 케이지 존재
//단, 3종류의 동물 수는 항상 변함...
class Animal{
    public void bark(){
        System.out.println("동물들이 웁니당");
    }
}
//@~~~~~ : 어노테이션(Anotation)
public class Dog extends Animal {
    @Override //어노테이션은 개발자의 실수방지를 위해 사용한다.
    public void bark(){
        System.out.println("멍멍");
    }
}
class Cat extends Animal{
    public void bark(){
        System.out.println("야옹");
    }
}
class Cow extends Animal{
    public void bark(){
        System.out.println("음뮁");
    }
}
