package class_basic.car;

import javax.management.ObjectName;

//자동차는 제조사, 차이름, 차량번호, 가격, 소유주의 속성
public class Car {
    String brand; //자동차 제조사
    String modelName; // 자동차 이름
    String carNumber; // 자동차 번호판
    int price; //자동차 가격
    String owner; // 자동차 소유주


    // 자동차의 속성 하나하나를 각각 변경하는 메소드 만들기

    // 제조사 값을 변경하는 메서드
    public void setBrand(String a){
        brand = a;
    }
    // 차이름을 변경하는 메서드
    public void setModelName(String b){
        modelName = b;
    }
    //차량번호를 변경하는 메서드
    public void setCarNumber(String c ){
        carNumber= c;
    }

    //가격을 변경하는 메서드
    public void setPrice(int d){
        price = d;
    }

    //소유주를 변경하는 메서드
    public void setOwner(String e){
        owner = e;
    }

    //자동차의 속성 출력
    public void printCarInto(){
        System.out.println("브랜드 : " + brand );
        System.out.println("차량이름 : " + modelName );
        System.out.println("차량번호 : " + carNumber );
        System.out.println("가격 : " + price );
        System.out.println("소유주 : " + owner );

    }

}
