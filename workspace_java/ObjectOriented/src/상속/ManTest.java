package 상속;

//상속의 개념으로 알아서 채워진다???????
//
public class ManTest {
    public static void main(String[] args) {

        BusinessMan bm = new BusinessMan();
        System.out.println(bm.company);
        bm.tellCompany();


        System.out.println(bm.name);
        bm.tellName();




    }
}
