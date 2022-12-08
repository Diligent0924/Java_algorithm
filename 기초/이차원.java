package 기초;

import java.util.Arrays;
public class 이차원 {
    public static void main(String[] args) {
        int sum = 0;
        int [][] graph = {{1,2,3},{4,-1,6},{7,8,9}};
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(graph[i][j] == -1){
                    sum += graph[i+1][j];
                    sum += graph[i-1][j];
                    sum += graph[i][j-1];
                    sum += graph[i][j+1];
                }
            }
            System.out.println(Arrays.toString(graph[i]));
        }
        System.out.println(sum);
    }
}
