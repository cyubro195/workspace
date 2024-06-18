package class_basic.rect;

public class Rectangle {
    int x1;
    int y1; // 한쌍

    int x2;
    int y2; // 한쌍

    //생성자
    public Rectangle(){} //매개변수때문에 넣어줘야함!
    public Rectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void set(int x1, int y1,int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int square(){
        return (x2 - x1) * (y2 -y1);
    }
    // 좌표 정보, 넓이 출력
    // (1,2),(5,7)
    public void show(){
        System.out.println("(" + x1 + ", " + y1 + ")," +
                "(" +x2+","+y2+"),");
        System.out.println("사각형의 넓이 : " + square());
    }

    //인자로 전달된 객체 r과 현 객체가 같은 넓이라면 리턴 true
    public boolean equals(Rectangle r){
        if (r.square() == square()) {
            return true;
        }
        else {
            return false;
        }
    }





}

