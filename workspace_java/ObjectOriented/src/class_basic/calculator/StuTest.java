package class_basic.calculator;

//배열 + 클래스
public class StuTest {
    public static void main(String[] args) {
    //학생(student class)을 5명 저장할 수 있는 배열 생성
    //int[] arr = new int[5] 연습예제

        //학생 5명을 저장할 수 있는 통을 만드다...ㅎ
        Student[] students = new Student[5]; //앞에 동일한거 넣으면 댐

        //배열에 저장할 학생 객체생성
        Student s1 = new Student("김",20,80);
        Student s2 = new Student("이",25,70);
        Student s3 = new Student("박",26,90);
        Student s4 = new Student("최",29,50);
        Student s5 = new Student("홍",27,30);

        //배열 0번째 요소와 학생 s1 저장
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        students[3] = s4;
        students[4] = s5;

        // 1. 배열에 저장된 모든 학생의 이름,나이,점수를 출력
/*
        for(int i = 0; i < students.length; i++){
            students[i].print();
            System.out.println();
        }//반복문
 */
        //1문제를 for-each문으로 해결
       /* for( Student s : students){
            s.print();
            System.out.println();
        }
*/


        // 2. 배열에 저장된 학생 중 점수가 80점 이상인
        //학생의 이름,나이,점수 출력
      /*  for(int i = 0; i < students.length; i++){//반복문ㄴ
            if(students[i].getScore() >= 80){ // 80점이상인 학생들을
                students[i].print(); // 출력해줘
            }
        }*/

        //3. 이름이 '박'인 학생을 찾아 해당 학생의 나이를 10으로 변경
        // for, for-each???????????????????????????

        for(int i = 0; i < students.length; i++){
            if (students[i].getName().equals("박")){
                students[i].setAge(10);
            }
        }
        s3.print();

        for( Student e : students ){
            if (e.getName().equals("박")){
                e.setAge(10);
            }
        }








    }
}
