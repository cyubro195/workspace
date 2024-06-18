package collection.list;

public class Emp {
    private int empNo;
    private String name;
    private String dept;
    private String tel;
    private int money;

    //매개변수 생성자 만들기
    public Emp(int empNo, String name, String dept, String tel, int money) {
        this.empNo = empNo;
        this.name = name;
        this.dept = dept;
        this.tel = tel;
        this.money = money;
    }

    public int getEmpNo(){
        return empNo;
    }


    //사원의 연락처 마지막 4자리값 리턴 1111-2222
    public String getPw(){

        /*
        String num = "010-2345-2222";
        num.substring(5); // 111-2222 , 짝대기까지 순번에 포함해야함!
        num.substring(1,4); // "10-" 이렇게 마옴!
        */
        return tel.substring(5);

    }

    public String getName(){
        return name;
    }
    public String getDept(){
        return dept;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
