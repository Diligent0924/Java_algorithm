package 실버.실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ16139 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] word = bf.readLine().split(""); //String 한글자씩 넣는다.
        N = Integer.parseInt(bf.readLine()); // N의 숫자를 가져온다.
        HashMap<String, ArrayList<Integer>> store = new HashMap<>(); // 문자를 재정의해서 넣는 방식
        for (int i = 0; i < N; i++){
            StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
            String a = str0.nextToken();
            int b = Integer.parseInt(str0.nextToken());
            int c = Integer.parseInt(str0.nextToken());
            int result = 0;
            Boolean sub = false;
            if (store.containsKey(a)) sub = true;
            if(sub){
                result = store.get(a).get(2);
                for (int h = b; h < store.get(a).get(0); h++){
                    if (word[h].equals(a)) result ++; 
                }
                for (int h = store.get(a).get(1)+1; h < c+1; h++){
                    if (word[h].equals(a)) result ++;
                }
            }else{
                for (int j = b; j < c+1; j++){ // 전체를 훑는 방법
                    if (word[j].equals(a)) result ++;
                }
            }
            if (store.containsKey(a) && result > store.get(a).get(2)){
                ArrayList<Integer> value = new ArrayList<>();
                value.add(b);
                value.add(c);
                value.add(result);
                store.put(a, value);
            }
            System.out.println(result);
        }

    }
}
