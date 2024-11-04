public class GetterableTest {
    public static void main(String[] args) {
      Getterable g = () -> System.out.println(11);
      g.getNum();

      // 조금 더 줄일수있나?
      // 람다로 구현한 메서드의 내용 부분이 한 줄이라면 {} 생략가능
        Getterable g1 = () -> System.out.println(11);
        g.getNum();
    }

}
