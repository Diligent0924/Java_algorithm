package 실버.실버1;

import java.io.*;
import java.util.*;

public class 직각사각형2 {
    private static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine()); // N을 입력한다.
        int result = 0; // 결과값이 있기 위한 조건이다.
        long[] point_x = new long[N]; // 5개만큼의 공간을 가지는 Array를 생성한다.
        long[] point_y = new long[N]; // 5개만큼의 공간을 가지는 Array를 생성한다.
        for (int i = 0; i < N; i++){ // point라는 공간 안에 데이터를 집어넣는다.
            StringTokenizer str1 = new StringTokenizer(bf.readLine(), " ");
            long x_point = Integer.parseInt(str1.nextToken());
            long y_point = Integer.parseInt(str1.nextToken());
            point_x[i] = x_point;
            point_y[i] = y_point;
        }
        
        for (int i = 0; i < N-2 ; i++){
            for (int j = i+1; j < N-1; j++){
                for (int h = j+1; h < N; h++){
                    // System.out.printf("%d %d %d", i,j,h);
                    // System.out.println();
                    long s1 = (point_x[i] - point_x[j]) * (point_x[i] - point_x[j])  + (point_y[i]-point_y[j]) * (point_y[i]-point_y[j]);
                    long s2 = (point_x[i] - point_x[h]) * (point_x[i] - point_x[h])  + (point_y[i]-point_y[h]) * (point_y[i]-point_y[h]);
                    long s3 = (point_x[j] - point_x[h]) * (point_x[j] - point_x[h])  + (point_y[j]-point_y[h]) * (point_y[j]-point_y[h]);
                    if (s3 == s1+s2||s2 == s3 + s1|| s1== s2+s3){
                        result += 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
