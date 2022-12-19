// 모든 경우의 수를 다 찾아보는건 맞는듯?
// 다익스트라는 BFS로 반드시 해야한다.
package 골드4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1261 {
    private static int M, N;
    private static int[][] graph;
    private static int[][] visited;
    private static int[][] delta = {{-1,0},{1,0},{0,1},{0,-1}};
    static void bfs(){
        visited[0][0] = 0;
        int[] first = {0,0};
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(first);
        while (!queue.isEmpty()){
            int[] value = queue.removeFirst();
            // System.out.println(Arrays.toString(value));
            int i = value[0];
            int j = value[1];
            for (int d = 0; d < 4; d++){
                int ni = i + delta[d][0];
                int nj = j + delta[d][1];
                int c = visited[i][j];
                if (ni >= 0 && ni < N && nj >=0 && nj < M){
                    if (graph[ni][nj] == 1){
                        c ++;
                    }

                    if (visited[ni][nj] > c){
                        visited[ni][nj] = c;
                        int[] v = {ni,nj};
                        queue.add(v);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
        M = Integer.parseInt(str0.nextToken());
        N = Integer.parseInt(str0.nextToken());
        graph = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++){
            String[] str1 = bf.readLine().split("");
            Arrays.fill(visited[i], Integer.MAX_VALUE);
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(str1[j]);
            }
        }
        // System.out.println(Arrays.deepToString(graph));
        bfs();
        // System.out.println(Arrays.deepToString(visited));
        System.out.println(visited[N-1][M-1]);
    }
}
