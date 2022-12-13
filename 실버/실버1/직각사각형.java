package 실버.실버1;

import java.util.*;
import java.io.*;

public class 직각사각형 {
    private static long[] point_x;
    private static long[] point_y;
    private static int N;
    private static int result;
    private static ArrayList<long []> point_index;
    private static int[] visited;
    
    static void backtracking(int root, int start){ // point_index : 3개의 꼭지점을 할 index, root : 점의 개수
        if (root == 3){ // 만약 꼭지점이 3개일 경우에는
            // System.out.println(point_index);
            long s1 = (point_index.get(0)[0] - point_index.get(1)[0]) * (point_index.get(0)[0] - point_index.get(1)[0])  + (point_index.get(0)[1] - point_index.get(1)[1]) * (point_index.get(0)[1] - point_index.get(1)[1]);
            long s2 = (point_index.get(0)[0] - point_index.get(2)[0]) * (point_index.get(0)[0] - point_index.get(2)[0])  + (point_index.get(0)[1] - point_index.get(2)[1]) * (point_index.get(0)[1] - point_index.get(2)[1]);
            long s3 = (point_index.get(1)[0] - point_index.get(2)[0]) * (point_index.get(1)[0] - point_index.get(2)[0])  + (point_index.get(1)[1] - point_index.get(2)[1]) * (point_index.get(1)[1] - point_index.get(2)[1]);
            if (s3 == s1+s2||s2 == s3 + s1|| s1== s2+s3){
                result += 1;
            }
        }
        else{
            for (int i = start; i < N; i++){
                if (visited[i] == 0){
                    visited[i] = 1;
                    int started = i;
                    long [] a = {point_x[i],point_y[i]};
                    point_index.add(a);
                    backtracking(root+1, started); // point_index에 해당 숫자를 더하고 root도 한개 더한다.
                    point_index.remove(root);
                    visited[i] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); // N을 입력한다.
        result = 0; // 결과값이 있기 위한 조건이다.
        point_x = new long[N]; // 5개만큼의 공간을 가지는 Array를 생성한다.
        point_y = new long[N]; // 5개만큼의 공간을 가지는 Array를 생성한다.
        for (int i = 0; i < N; i++){ // point라는 공간 안에 데이터를 집어넣는다.
            StringTokenizer str1 = new StringTokenizer(bf.readLine(), " ");
            point_x[i] = Integer.parseInt(str1.nextToken());
            point_y[i] = Integer.parseInt(str1.nextToken());
        }
        point_index = new ArrayList<long []>();
        visited = new int[N];
        backtracking(0,0);
        System.out.println(result);
    }
}
