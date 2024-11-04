
public class LocalOuter {
    private String content;
    public LocalOuter(String content){
        this.content = content;
    }
    public Printable getPrinter(){
        //Printable 인터페이스의 객체생성
        //1) 인터페이스만으로는 객체 생성 불가
        //   -> 인터페이스를 구현한 클래스를 먼저 생성
        //   -> 해당 클래스에 대한 객체 생성

        //Printable

        // ------로컬 이너 클래스 --- //
        // Printable 인터페이스를 구현한 클래스
        class MyPinter implements Printable {
            public void print(){
                System.out.println("프린터 실행~");



        MyPinter p = new MyPinter();
        // ------로컬 이너 클래스 끝--- //

        // ---- 로컬 이너 클래스 -> 익명 이너 클래스 변환 ---//
                Printable p1 = new Printable(){
                    public void print() {
                        System.out.println(111);
                    }
                };

        // ---- 로컬 이너 클래스 -> 익명 이너 클래스 변환 끝!---//

        }
        Printable p = new MyPinter(); // < 애도 가능함 위아래 같은 의미

        // ------ 익명 --> 람다로의 변환 ---//
        Printable p2 = () -> {System.out.println(111);};

        // ------ 익명 --> 람다로의 변환 끝!!!!! ---//


        //생성한 객체를 리턴
        return p;
    }

}
