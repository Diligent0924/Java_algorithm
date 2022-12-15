package 실버.실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {
    private static int N;
    private static int[] subset_list;
    private static int[][] graph;
    private static long sour;
    private static long sweet;
    private static long result = 2000000000;


    static void subset(){
        int count = -1; // 제일 첫번째의 경우를 지우기 위해서 사용한다.
        for (int i = 0; i < (1 << N) ; i++){ // 비트연산자 i
            sour = 1; // 매번 비교를 해야하기 때문에 초기값으로 변경해야한다.
            sweet = 0;
            count ++;
            if (count != 0){ // 제일 첫번째 값은 필요하지 않음
                for (int j = 0; j < N; j++){ // 비트연산자 j
                    if ((i & 1 << j) != 0){ // Python : i & (1<<j) 와 같은 개념
                        sour *= graph[j][0]; // 값을 바로 집어넣는다.
                        sweet += graph[j][1]; // 
                    }
                }
                if (result > Math.abs(sour-sweet)){
                    result = Math.abs(sour-sweet);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        graph = new int[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
            graph[i][0] = Integer.parseInt(str0.nextToken());
            graph[i][1] = Integer.parseInt(str0.nextToken());
        }
        subset();
        System.out.println(result);
    }
}
