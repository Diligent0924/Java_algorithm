package 실버.실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11052 {
    static int N;
    static int[] graph;
    static int[] DP;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new int[N+1];
        StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
        for (int i = 1; i < N+1; i++){
            graph[i] = Integer.parseInt(str0.nextToken());
        }
        DP = new int[N+1]; // DP로 최댓값을 계속 갱신해가면서 확인하는 방법
        DP[1] = graph[1]; // 인덱스 1의 경우에는 1개밖에 없다.
        for (int i = 2; i<N+1; i++){
            for (int j = 0; j < i; j++){ // i보다 작을 때의 리스트를 모두 확인해본다.
                if (DP[j] + graph[i-j] > DP[i]){// 만약 현재 graph[i_index - j_index] + graph[j_index]
                    DP[i] = DP[j] + graph[i-j];
                } 
            }
        }
        System.out.println(DP[N]);
    }
}
