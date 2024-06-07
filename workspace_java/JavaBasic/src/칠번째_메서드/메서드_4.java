package 칠번째_메서드;

public class 메서드_4 {
    public static void main(String[] args) {
        introduction("자바",20,"울산");

        String a = "홍히히";
        int b = 40;
        String c = "제주도";

        introduction(a,b,c);
    }
    // int age = b;
    public static void introduction(String name, int age, String addr){
        // String name = a;
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("주소 : " + addr);
    }

}
