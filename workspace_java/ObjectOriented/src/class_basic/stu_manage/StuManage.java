package class_basic.stu_manage;

import class_basic.mem.Sub;

import java.util.Scanner;

public class StuManage {
    private Scanner sc; // 키보드 입력을 위해 선언
    private Stu[] students; // 학생 다 수를 저장할 배열
    private int idx; // 학생 배열의 요소


    //생성자
    public StuManage(){
        sc = new Scanner(System.in);
        students = new Stu[3]; // 학생을 최대 3명까지 저장해야하기때문에
        idx = 0;
    }

    //학생등록 메서드
    public void regStu(){
        if (idx >= 3){
            System.out.println("더 이상 입력 할 수 없습니다");
        }
        else {
            System.out.println("학생등록실행합니다.학생정보를 입력하세요");
            System.out.println("이름 : ");
            String name = sc.next();
            System.out.println("나이 : ");
            int age = sc.nextInt();
            System.out.println("연락처 : ");
            String tel = sc.next();
            System.out.println("학점 : ");
            String grade = sc.next();

            //입력받은 정보로 학생 객체 생성
            Stu stu = new Stu(name, age, grade,tel);

            //생성한 학생 객체를 배열에 저장
            students[idx] = stu;
            idx++;
        }

    }
    //학생 정보변경(연락처) 메서드
    public void changeInfo(){
        System.out.println("정보를 변경하시겠습니까?");

        System.out.print("변경하실 학생의 이름을 입력하세요 : ");
        String name = sc.next();
        System.out.println("연락처 : ");
        String tel = sc.next();




        System.out.println("수정되었습니다");


    }
    //학생 정보출력 메서드
    public void print(){
        System.out.println("정보출력");
        String name = sc.next();

        for (int i = 0; i < idx; i++){
            if(students[i].getName().equals(name)){
                System.out.println("ㅇㅋ");
                students[i].showInfo();

            }
        }


    }
    //모든 학생 정보출력 메서드
    public void printAll(){
        System.out.println("모든 학생의 정보입니다. 현재 총 학생 수는 " + idx + "명입니다.");

        for(int i = 0; i < idx; i++){
            students[i].showInfo();
            System.out.println();
        }

    }





}
