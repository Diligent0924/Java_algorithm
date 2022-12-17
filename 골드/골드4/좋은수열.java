package 골드4;

import java.io.*;
public class 좋은수열 {
    private static int N;
    private static String [] permutation_number = {"1","2","3"}; // 1,2,3만 들어갈 수 있으므로 미리 정의

    static Boolean verification(String word){
        for (int i = 0; i < word.length()-1; i++){
            for (int j = 1; j <= word.length(); j++){
                System.out.printf("i : %d, j : %d",i,j);

                String word_1 = word.substring(i, j);// [0,1,2 ..] ~ i까지를 확인한다. 
                String word_2 = word.substring(j); // word_1과 길이가 동일하면서 맞는지를 확인한다.
                System.out.printf("word_1 : %s word_2 : %s", word_1, word_2);
                System.out.println();
                System.out.println(word_1 == word_2);
                if (word_1 == word_2){ // 만약 두 개의 String이 같게 나온다면..
                    return false; // 나쁜 숫자이므로 true로 반환한다.
                }
            }
        }
        return true; // 위의 모든 경우가 통과되었다면 false로 반환한다.
    }

    static void dfs(String word, int count){
        Boolean Ver = verification(word); // 들어간 값이 나쁜 숫자인지를 확인한다.
        if (Ver == false){
            return;
        }
        if (count == N){ // 만약 해당 글자 수만큼 들어갔다면
            System.out.println(word); // 해당 단어가 가장 크기가 작은 숫자이므로 print한다.
            System.exit(0); // 바로 마무리 짓는다.
        }
        else{ // 만약 글자가 더 작은 경우에는
            for (String i : permutation_number){ // 1,2,3을 순서대로 대입해가면서 확인해본다.
                char word_last_char = word.charAt(count-1);
                String word_last = "";
                word_last += word_last_char;
                if (word_last != i){
                    dfs(word + i, count+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        String word = "";
        for (String i: permutation_number){
            dfs(word + i, 1);
        }
    }
}
