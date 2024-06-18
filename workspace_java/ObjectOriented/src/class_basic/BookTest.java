package class_basic;

public class BookTest {
    public static void main(String[] args) {

        Book book1 = new Book("java","kim",1000);
        Book book2 = new Book("python","lee",2000);


        //자료형 변수명
        Book book3 = book1;//자료형이라서 가능!
        System.out.println(book1.title);
        System.out.println(book3.title);

        book1.title = "c++";
        System.out.println(book1.title);
        System.out.println(book3.title);

        //하나의 변수는 하나의 값만 저장가능
        int a = 10;
        int b = a;
        a = 5;
        System.out.println(a); //5
        System.out.println(b); //10






    }
}
