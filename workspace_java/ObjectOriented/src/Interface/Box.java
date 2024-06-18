package Interface;

//Wrapper class
//무엇이든 넣고 뺄 수 있는 만능상자 만들기.

public class Box {
    Object str;

    public void setBox(Object str){ //오브젝트 클래스는 클래스들의 자료형을 다 받을 수 있다고! 기억하라고! 젭알!
        this.str = str;
    }
    public Object getBox(){
        return str;
    }

}
