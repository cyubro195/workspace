package class_basic.man;

public class ManTest {
    public static void main(String[] args) {

        Man man = new Man("최두식",20,"울산");

        //이름 변경하기!
        man.setName("마동석");
        // set으로 수정하고 get으로 호출하기 잊지맛!
        System.out.println(man.getName());
        man.printMan();


    }
}
