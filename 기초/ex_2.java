package 기초;

public class ex_2 {
    public static void main(String[] args) {
        String org = "SSAFY"; // 작은 따음표와 큰 따음표가 차이가 있다.
        char [] chars = org.toCharArray(); // [변수].toChar
        for (int i = 0; i < chars.length; i++){
            System.out.println(chars[i]);
        }
    }
}
