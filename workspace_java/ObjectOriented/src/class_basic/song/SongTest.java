package class_basic.song;

public class SongTest {
    public static void main(String[] args) {

        Song song = new Song();

        String[] a = {"방시혁","박진영","유영진"}; // 작곡가 3명 넣어주기!
        song.initSong("잠이와요","박희동","1집",2024,a); //전체출력 메소드
        song.printSong();





    }
}
