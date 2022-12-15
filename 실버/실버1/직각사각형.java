// LinkedList => 추가/삭제가 많을 때 사용 , Array => 단순 조회가 많을 때 사용한다.
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
    
    static void backtracking(int root, int start){ // root : 현재 개수, start : Combination하기 위한 수
        if (root == 3){ // 만약 꼭지점이 3개일 경우에는
            // ArrayList, LinkedList의 경우에는 .get(index)로 값을, .indexOf(value)로 해당 값의 첫번쨰 인덱스를 가져온다.
            long s1 = (point_index.get(0)[0] - point_index.get(1)[0]) * (point_index.get(0)[0] - point_index.get(1)[0])  + (point_index.get(0)[1] - point_index.get(1)[1]) * (point_index.get(0)[1] - point_index.get(1)[1]);
            long s2 = (point_index.get(0)[0] - point_index.get(2)[0]) * (point_index.get(0)[0] - point_index.get(2)[0])  + (point_index.get(0)[1] - point_index.get(2)[1]) * (point_index.get(0)[1] - point_index.get(2)[1]);
            long s3 = (point_index.get(1)[0] - point_index.get(2)[0]) * (point_index.get(1)[0] - point_index.get(2)[0])  + (point_index.get(1)[1] - point_index.get(2)[1]) * (point_index.get(1)[1] - point_index.get(2)[1]);
            if (s3 == s1+s2||s2 == s3 + s1|| s1== s2+s3){
                result += 1;
            }
        }
        else{
            for (int i = start; i < N; i++){
                if (visited[i] == 0){ // contain보다는 visted라는 리스트를 하나 만드는 것이 훨씬 빠르게 작동한다.
                    visited[i] = 1; // 방문한 곳은 1로 둔다.
                    int started = i;
                    long [] a = {point_x[i],point_y[i]}; // 해당 값을 바로 저장한다.
                    point_index.add(a); // 저장한 값을 list에 더해준다. => 여기서 index를 추출하는게 아니라 값을 직접 입력해야 시간초과 안난다.
                    backtracking(root+1, started); // point_index에 해당 숫자를 더하고 root도 한개 더한다.
                    point_index.remove(root);
                    visited[i] = 0; // 방문한 곳은 0으로 둔다.
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
            point_x[i] = Integer.parseInt(str1.nextToken()); // 입력 받을 때 바로 넣어주는 것이 좋다.(매우 중요)
            point_y[i] = Integer.parseInt(str1.nextToken());
        }
        point_index = new ArrayList<long []>(); // ArrayList안에 어떤 수를 저장하고 싶다면 정확하게 명시해야한다.
        visited = new int[N]; // Pointer는 그대로 Global하게 쓰되 값만 새롭게 저장한다.
        backtracking(0,0); 
        System.out.println(result);
    }
}
