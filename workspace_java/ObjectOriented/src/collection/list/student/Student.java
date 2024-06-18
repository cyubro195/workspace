package collection.list.student;

public class Student {

    private String name;
    private int age;
    private int score;

    //생성자
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    //겟터
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    //셋터
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
