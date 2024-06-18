package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
    private List<Emp> empList; //리스트 선언
    private Scanner sc; //스캐너 만들기

    public EmpService(){

        sc = new Scanner(System.in);
        empList = new ArrayList<>(); //emplist 사원을 저장할 수 있는 통 만들기

        //사원넣기
        Emp e1 = new Emp(1001,"마석두","개발부","1111-2112",200);
        Emp e2 = new Emp(1002,"김필석","개발부","2211-2222",280);
        Emp e3 = new Emp(1003,"노선우","인사부","1211-2112",240);
        Emp e4 = new Emp(1004,"강학선","경영부","1231-2112",250);
        Emp e5 = new Emp(1005,"곽선팔","영업부","1111-2132",300);

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
        empList.add(e4);
        empList.add(e5);

    }

    //1번문제
    public void login(){
        boolean isRunning = true; //while문 반복변수
        boolean isFind = false; //찾으셧나용!?



        while (isRunning) { //사번을 반복해서 물어봐야함
            System.out.println("사번 : ");
            int empNo = sc.nextInt();
            System.out.println("비밀번호(연락처 마지막 4자리) : ");
            String pw = sc.next();

            //입력한 사번과 비밀번호가 일치여부 체크!
            for (Emp e : empList){
                if (e.getEmpNo() == empNo && e.getPw().equals(pw)) {
                    isRunning = false; // while문 벗어남!
                    System.out.println(" 로그인 하였습니다.");
                    System.out.println( e.getName() + "님 반갑습니다.");
                    isFind = true;

                }// else는 들어가면 안됨,
            }
            if (!isFind) { // '!' : 부정연산자, 못찾으면 이친구가 나옴!
                System.out.println("사번 혹은 비번이 일치하지 않습니다.");
            }
        }
    }


    //2번문제
    public void printDepMoney(){ //부서의 월급 정보를 출력
        System.out.println("부서명 : ");
        String dept = sc.next();

        int sum = 0; //월급평균만들기위해서 공간만들기
        int cnt = 0; //찾고자하는 인원수
        System.out.println("=="+ dept +"월급 현황==");
        for (int i = 0; i < empList.size(); i++){
            if (empList.get(i).getDept().equals(dept)){//내가 입력한 부서랑 맞는지 물어보는거
                System.out.println(empList.get(i));
                sum = sum + empList.get(i).getMoney(); //평균구하기
                cnt++; //+1 증가한다
            }
        }
        System.out.println( dept +"의 월급 총액은" + sum +"이며,평균 급여는" +(sum/(double)cnt)+ "입니다");


    }
    //3번문제
    public void increaseMoney(){

        System.out.println("부서명 : ");
        String dept = sc.next();

        System.out.println("인상급여 : ");
        int money = sc.nextInt();

        System.out.println(dept + "각 사원의 급여가"+"각각"+ money +"원씩 인상됩니다.");
        System.out.println("==월급 인상 후 "+ dept +"월급 현황==");

        //월급 인상시키기, 급여 인상코드
        for (Emp e : empList){
            if(e.getDept().equals(dept)){ //내가찾는부서와 동일한지 묻기
               int result = e.getMoney() + money;
                e.setMoney(result);
            }
        }

        //인상된 사원정보를 출력하기
        for (Emp e : empList){
            if (e.getDept().equals(dept)) {
                System.out.println(e); //입력한 동일한 사원만 출력
            }
        }





    }
}
