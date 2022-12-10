package 골드;

import java.io.*;
import java.util.*;
public class 로봇청소기 {
    static int [][] delta = {{-1,0},{0,1},{1,0},{0,-1}};
    // delta를 이용해서 돌리기 위한 함수
    static int direction(int value){
        switch (value){
            case -1 : return 3;
            case -2 : return 2;
            case -3 : return 1;
        }
        return value;
    }
    // 왼쪽으로 4번 돌았을 때 확인
    static int[] first(int now_i, int now_j, int D, int [][] graph, int N, int M, int direction_count){
        for (int l = 0; l < direction_count; l++){ // 4방향에 대해서 모두 확인해본다.
            D -= 1; // 해당 방향으로 둔다. (고정)
            int pro_i = now_i + delta[direction(D%4)][0]; // 앞으로 가게될 지역의 i
            int pro_j = now_j + delta[direction(D%4)][1]; // 앞으로 가게될 지역의 j
            if (pro_i >= 0 && pro_i < N && pro_j >= 0 && pro_j < M && graph[pro_i][pro_j] == 0){ // 만약 가려는 곳이 0으로 되어있다면..
                now_i = pro_i; // 현재 위치를 이동시킨다.(i) => 안넘어온다? 왜 안넘어오지??
                now_j = pro_j; // 현재 위치를 이동시킨다.(j) 
                int [] arr_1 = {now_i, now_j, D};
                return arr_1;
            }
        }
        int [] arr_1 = {-1,-1};
        return arr_1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 한번에 읽어오기
        StringTokenizer str1 = new StringTokenizer(bf.readLine(), " "); // str1으로 띄어서 읽어오기
        int N = Integer.parseInt(str1.nextToken());
        int M = Integer.parseInt(str1.nextToken());
        // 로봇청소기가 있는 칸의 좌표를 확인함
        StringTokenizer str2 = new StringTokenizer(bf.readLine(), " "); // str1으로 띄어서 읽어오기
        int R = Integer.parseInt(str2.nextToken()); // 로봇청소기의 x축 좌표
        int C = Integer.parseInt(str2.nextToken()); // 로봇청소기의 y축 좌표 
        int D = Integer.parseInt(str2.nextToken()); // 로봇청소기가 현재 바라보는 좌표
        // 그래프를 입력함.
        int [][] graph = new int[N][M];
        for (int i = 0; i < N; i++){
            StringTokenizer s = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < M; j++){
                graph[i][j] = Integer.parseInt(s.nextToken());
            }
        }
        // System.out.println(Arrays.deepToString(graph));
        int result = 0; // 최종 개수를 확인하기 위한 변수
        int now_i = R; // 현재 위치를 계속 알려주는 역할(i)
        int now_j = C; // 현재 위치를 계속 알려주는 역할(j)
        while(true){ // 만약 왼쪽으로 잘 돌아갔을 때 다시 시작하기 위하여 사용한다.
            // System.out.println(Arrays.deepToString(graph));
            // System.out.printf("now_i : %d now_j : %d direction : %d",now_i,now_j,D);
            // System.out.println();
            result += 1; // result의 개수를 +1씩 해준다.
            graph[now_i][now_j] = 2; // 현재 위치를 청소한 것이라고 판단한다.  
            int[] result_1 = first(now_i, now_j, D, graph, N, M, 4); // 만약 해당 위치 중 4방향에 갈 수 있는 곳이면 1, 아니면 0       
            if (result_1[0] != -1){
                now_i = result_1[0];
                now_j = result_1[1];
                D = result_1[2];
            }
            else{ // 만약 4방향이 모두 안되었을 때 
                while (true){ // 될 때까지 계속 뒤로 한칸씩 빼야됨
                    // int result_2 = -1;
                    now_i = now_i + delta[direction((D-2)%4)][0]; // 뒤로 한칸 빼기 위한 변수(i)
                    now_j = now_j + delta[direction((D-2)%4)][1]; // 뒤로 한칸 빼기 위한 변수(j)
                    if (now_i >= 0 && now_i < N && now_j >= 0 && now_j < M && graph[now_i][now_j] != 1){ // 모든 조건이 통과된다면
                        int[] result_2 = first(now_i, now_j, D, graph, N, M, 3); // 확인해본다.
                        if (result_2[0] != -1){ // 3방향 확인 후 갈 수 있는 자리가 있다면...
                            now_i = result_2[0]; // 해당 위치를 저장한다.
                            now_j = result_2[1]; 
                            D = result_2[2];
                            break;
                        }
                    }
                    else{ // 더이상 뒤로 갈 곳이 없다면 끝낸다.
                        // System.out.println("---------------");
                        System.out.println(result);
                        System.exit(result);
                    }
                }
            }
        }
    }
}
