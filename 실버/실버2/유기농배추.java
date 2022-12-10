package 실버.실버2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class 유기농배추 {
    static int [][] delta = {{0,1},{0,-1},{1,0},{-1,0}}; // 전역변수로 사용하는 곳

    static int result(int N, int M, int [][] cabbage){ // 1이있는 곳을 찾아서 bfs로 돌리기 위해 빼내는 방법 
        // System.out.println(N);
        // System.out.println(M);
        int count = 0;
        for (int a = 0; a < N; a++){
            for (int b = 0; b < M; b++){
                if (cabbage[a][b] == 1){ // 만약 1이라면 count를 하나 더해주고 bfs로 간다.
                    count += 1;
                    bfs(a,b, cabbage, N, M);
                    // System.out.println(Arrays.deepToString(cabbage)); // 2차원배열을 확인하기 위한 방법
                }
            }
        }
        return count;
    }

    static void bfs(int start_i, int start_j, int [][] cabbage, int N, int M){
        LinkedList<Integer> queue_i = new LinkedList<>(); // i의 값을 저장한다.(LinkedList는 하나의 값만 들어감)
        LinkedList<Integer> queue_j = new LinkedList<>(); // j의 값을 저장한다.(LinkedList는 하나의 값만 들어감)
        queue_i.addLast(start_i); // addLast와 push 차이는 ? 
        queue_j.addLast(start_j);
        cabbage[start_i][start_j] = 0; // 처음 들어가는 곳은 0으로 만들어준다.
        while (!queue_i.isEmpty()){
            int i = queue_i.pop();
            int j = queue_j.pop();
            // System.out.printf("%d %d",i, j);
            // System.out.println();
            for (int d = 0; d < 4; d++){
                int ni = i + delta[d][0];
                int nj = j + delta[d][1];
                // System.out.printf("ni : %d nj : %d",ni, nj);
                // System.out.println();
                if (ni >= 0 && ni < N && nj >= 0 && nj < M && cabbage[ni][nj] == 1){
                    cabbage[ni][nj] = 0; // 여기서 0으로 처리하고 가게끔 해야한다.
                    queue_i.push(ni); // ni값을 추가한다.
                    queue_j.push(nj); // nj값을 추가한다.
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // Input하기 위한 방법
        int tc = Integer.parseInt(bf.readLine()); // N을 입력받는다.
        for (int i = 0; i < tc; i++){ // TestCase만큼 돌린다.
            StringTokenizer str1 = new StringTokenizer(bf.readLine(), " "); // 띄어쓰기를 기준으로 나눈다.
            int M = Integer.parseInt(str1.nextToken()); // M을 확인한다.
            int N = Integer.parseInt(str1.nextToken()); // N을 확인한다.
            int K = Integer.parseInt(str1.nextToken()); // K를 확인한다.
            int [][] cabbage = new int[N][M]; // cabbage를 미리 만들어놓는다.
            for (int j = 0; j < K; j++){ // K개수만큼 데이터를 받아온다.
                StringTokenizer position = new StringTokenizer(bf.readLine(), " "); // 데이터를 변환한다.
                int garo = Integer.parseInt(position.nextToken());
                int sero = Integer.parseInt(position.nextToken());
                cabbage[sero][garo] = 1; // 해당 위치를 1로 변경한다.
            }
            // 입력을 전부 받은 후 bfs를 시작한다.
            // System.out.println(Arrays.deepToString(cabbage)); // 2차원배열을 확인하기 위한 방법
            
            int count = result(N,M,cabbage);
            System.out.println(count);
        }

    }
}
