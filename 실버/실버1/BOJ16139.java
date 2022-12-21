package 실버.실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16139 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] word = bf.readLine().split(""); //String 한글자씩 넣는다.
        N = Integer.parseInt(bf.readLine()); // N의 숫자를 가져온다.
        String[] store_1 = new String[N];
        Arrays.fill(store_1, ".");
        int[][] store_2 = new int[N][2];
        int[] store_3 = new int[N];

        for (int i = 0; i < N; i++){
            StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
            String a = str0.nextToken();
            int b = Integer.parseInt(str0.nextToken());
            int c = Integer.parseInt(str0.nextToken());
            int result = 0;
            Boolean sub = false;
            for (int j = 0; j < N; j++) { // 저장소안에 겹치는 것이 있는가를 확인해봐야한다.
                if (store_1[j].equals(a) && b <= store_2[j][0] && c >= store_2[j][1]){ // 안에 부분집합으로 들어가있는 경우에는..
                    sub = true;
                    result = store_3[j]; // 일단 부분집합을 빼고
                    for (int h = b; h < store_2[j][0]; h++){
                        if (word[h].equals(a)) result ++; 
                    }
                    for (int h = store_2[j][1]+1; h < c+1; h++){
                        if (word[h].equals(a)) result ++;
                    }
                    break;
                }
            }
            if (!sub){
                for (int j = b; j < c+1; j++){ // 전체를 훑는 방법
                    if (word[j].equals(a)) result ++;
                }
            }
            store_1[i] = a;
            store_2[i][0] = b;
            store_2[i][1] = c;
            store_3[i] = result;
            System.out.println(result);
        }

    }
}
