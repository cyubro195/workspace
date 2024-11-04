public class Student {
    private int stuNum;
    private String stuName;


    public Student(int stuNum, String stuName) {
        this.stuNum = stuNum;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum=" + stuNum +
                ", stuName='" + stuName + '\'' +
                '}';
    }


    public void setStuNum(int stuNum) {
        this.stuNum = stuNum;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuNum() {
        return stuNum;
    }
    public String getStuName() {
        return stuName;
    }



}
