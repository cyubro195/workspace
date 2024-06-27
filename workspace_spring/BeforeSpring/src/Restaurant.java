public class Restaurant {

    private Chef chef; //요리사라는 한명의 객체 만들기

    public Restaurant(){
        chef = new Chef(); //선언
    }

    //메소드 만들기
    public void service(){
        System.out.println("영업을 시작합니다.");
        chef.makeCook();
    }

}
