package collection.list.student;

import java.util.List;

public class School {
    private List<StudyClass> classList;

    public School(List<StudyClass> classList){
        this.classList = classList;
    }

    // 놀랍게도 애도 List<StudyClass> 자료형이라 들어갈수있음!
    public List<StudyClass> getClassList(){
        return classList;
    }



}
