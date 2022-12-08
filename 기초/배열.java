package 기초;

public class 배열 {
    public static void main(String[] args) {
        char [] word = new char[5]; // 그냥 List를 만드는 경우에 사용
        char [] new_word = new char[]{1,2,3,4,5}; // List를 넣어서 바로 만드는 경우에 사용
        String [] change_word = new String[]{"SSAFY","NO","LEARN"};
        System.out.println(change_word[0]);
        // for (int i = 0; i < 3; i++){ 
        //     new_word[i] = change_word[i]; // 같은 문자 타입이 아닌 경우에는 무조건 Error가 발생함
        // }
    }
}
