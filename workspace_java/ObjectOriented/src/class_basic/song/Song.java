package class_basic.song;

public class Song {

    // 모든 참조자료형은 기본 초기값 null
    String title;
    String artist;
    String album;
    int year;
    String[] composer;
    // (단,작곡가 3명) > 넣어야하니까 배열에 공간 넣어주기

    // song 클래스 만들기
    public void initSong(String title1, String artist1, String album1, int year1,
                         String[] composer1){
        title = title1;
        artist = artist1;
        album = album1;
        year = year1;
        composer = composer1;

    }

    public void printSong(){
        System.out.println(" 제목 : " + title );
        System.out.println(" 가수 : " + artist );
        System.out.println(" 앨범 : " + album);
        System.out.println(" 년도 : " + year );
        System.out.println(" 작곡 : ");

        for(int i = 0; i < composer.length; i++){
            System.out.print(composer[i] + " "); // 배열에 반복하기 위해.
        }
    }

}
