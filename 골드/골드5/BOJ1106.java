package 골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ1106 {
    
    public static void main(String[] args) throws IOException{
        // 입력 받는 곳
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
        int C = Integer.parseInt(str0.nextToken());
        int N = Integer.parseInt(str0.nextToken());
        int [] result = new int [C + 101]; // 각각의 고객의 수마다 확인해서 최종으로 가려고 한다.
        Arrays.fill(result, Integer.MAX_VALUE);
        int f = 900000000;
        result[0] = 0;
        for (int i = 0; i < N; i++){
            StringTokenizer str1 = new StringTokenizer(bf.readLine(), " ");
            int cost = Integer.parseInt(str1.nextToken()); // 홍보 비용
            int customer = Integer.parseInt(str1.nextToken()); // 고객의 수
            for (int j = customer; j < C+101; j++){
                int prev = result[j-customer];
                if (prev != Integer.MAX_VALUE) result[j] = Math.min(result[j], cost + prev);
            }
        }
        
        

        // System.out.println(Arrays.toString(result));
        System.out.println(Math.min(f,result[C]));
    }
}
