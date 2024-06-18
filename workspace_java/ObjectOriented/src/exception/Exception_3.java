package exception;

public class Exception_3 {
    public static void main(String[] args) {
       try {
           bbb(); // << 애가 책임져아햠
       }catch (Exception e){

       }
    }

    public static void aaa() throws Exception {//예외처리안하고 던져버릴래~, aaa를 들고있는애가 감당해야함!
        System.out.println( 5 / 0 );
    }

    public static void bbb() throws Exception {
        aaa();
    }







}
