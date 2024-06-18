package object;

public class String_4 {
    public static void main(String[] args) {

        String a = "짜장면";
        String b = "짬뽕";

        //concat : 두 문자열을 나열(+와 동일)
        System.out.println(a.concat(b));
        a.concat(b);

        //substring:문자열에서 일부만 추출하는 기능
        String str1 = "abcdefg"; //0 = a ,1 = b, 2 = c
        System.out.println(str1.substring(2));//2번째 글자부터 추출하겠댜
        //2번째 글자부터 4번째 글자 전까지 추출.
        System.out.println(str1.substring(2,4));//앞은 포함, 뒤는 포함하지않고 전꺼만.

        //length : 문자열 길이
        String str2 = "집에 가고싶다";
        System.out.println(str2.length());

        String str3 = "피자,치킨,족발";
        String[] result = str3.split(",");// ','를 기준으로 잘라주세요.
        System.out.println(result[1]);







    }
}
