public interface LambdaPractice {
    void printName();
}

interface LambdaPractice1 {
    void printName(String name);
}

interface LambdaPractice2 {
    void printMyInfo(String name, int age);
}

interface LambdaPractice3 {
    int getData();
}

interface LambdaPractice4 {
    int getResult(int a, int b);
}

// 람다식을 쓰기 위한 인터페이스
// 제네릭 활용
@FunctionalInterface //람다식으로만 쓴다는거 추상적인거 하나만!통제
interface LambdaPractice5<T> {
    T getResult(T a, T b);
}

@FunctionalInterface //람다식으로만 쓴다는거 추상적인거 하나만!통제
interface LambdaPractice6<T, R> {
    R getResult(T a, T b);
}