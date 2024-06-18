package Interface.student;

public class Student {
    private String name;
    private int korScore; //국어
    private int mathScore;//수학
    private int engScore;//영어


    public Student(String name, int korScore, int mathScore, int engScore) {
        this.name = name;
        this.korScore = korScore;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }


    //get/set 만들기

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }


}
