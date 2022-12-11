package 실버.실버1;

import java.io.*;
import java.util.*;

public class 음식물피하기 {
    private static int N, M, K;
    private static int [][] graph;
    private static int count;

    static void bfs(int i, int j){
        if (i >= 0 && i < N && j >= 0 && j < M && graph[i][j] == 1){ // graph가 0일때만 확인한다.
            graph[i][j] = 0;
            count += 1;
            bfs(i+1, j);
            bfs(i-1, j);
            bfs(i, j+1);
            bfs(i, j-1);
        }
    }
    
    static int max(int max_count, int count){
        if (count > max_count){
            max_count = count;
        }
        return max_count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str1 = new StringTokenizer(bf.readLine(), " ");
        N = Integer.parseInt(str1.nextToken()); // 세로길이 (앞에 int같은걸 안쓰면 새롭게 point하지 않겠다는걸 의미)
        M = Integer.parseInt(str1.nextToken()); // 가로길이
        K = Integer.parseInt(str1.nextToken()); // 음식물 쓰레기 개수
        graph = new int[N][M]; // 그래프를 그린다.
        for (int i = 0; i < K; i++){
            StringTokenizer str2 = new StringTokenizer(bf.readLine(), " ");
            int trash_i = Integer.parseInt(str2.nextToken()); // 음식물 쓰레기 i 위치
            int trash_j = Integer.parseInt(str2.nextToken()); // 음식물 쓰레기 j 위치
            graph[trash_i-1][trash_j-1] = 1;
        }
        int max_count = 0; // 최대 카운트를 확인한다.
        for (int i = 0; i < N; i ++){
            for (int j = 0; j < N; j++){
                if (graph[i][j] == 1){
                    count = 0; // count를 항상 초기화해준다.
                    bfs(i,j);
                    max_count = max(max_count,count);
                }
            }
        }
        System.out.println(max_count);
    }
}
