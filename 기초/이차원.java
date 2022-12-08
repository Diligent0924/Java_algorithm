package 기초;

import java.util.Arrays;

public class 이차원 {
    static int [][] graph = {{1,2,3},{4,-1,6},{7,8,9}};
    static int [][] delta = {{0,-1},{0,1},{1,0},{-1,0}};

    static int deltas(int i, int j){
        int sum = 0;
        for (int h = 0; h < 4; h++){
            int ni = i + delta[h][0];
            int nj = j + delta[h][1];
            if (ni >= 0 && ni < 3 && nj >= 0 && nj < 3){
                sum += graph[ni][nj];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (graph[i][j] == -1){
                    result += deltas(i, j);
                }
            }
        }
        System.out.println(result);
    }
}
