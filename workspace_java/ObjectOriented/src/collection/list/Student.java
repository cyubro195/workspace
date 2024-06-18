package collection.list;

//학생정보
//학생이름, 국어점수, 영어점수, 총점 데이터
public class Student {

    private String name;
    private int korscore;
    private int engscore;
    private int totalScore;

    public Student(){}
    public Student(String name, int korscore, int engscore) {
        this.name = name;
        this.korscore = korscore;
        this.engscore = engscore;
        this.totalScore = totalScore = korscore + engscore; // 총합 스코어
    }

    //GETTER
    public String getName() {
        return name;
    }

    public int getKorscore() {
        return korscore;
    }

    public int getEngscore() {
        return engscore;
    }

    public int getTotalScore() {
        return totalScore;
    }


    //SETTER
    public void setName(String name) {
        this.name = name;
    }

    public void setKorscore(int korscore) {
        this.korscore = korscore;
    }

    public void setEngscore(int engscore) {
        this.engscore = engscore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    //over
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", korscore=" + korscore +
                ", engscore=" + engscore +
                ", totalScore=" + totalScore +
                '}';
    }
}
