// 0,4,7로 미리 리스트를 만든 다음에 between 방식으로 확인하자!
package 실버.실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 금민수의개수 {
    private static int A, B, result;

    static void fourseven(long number){
        if (number > B) return;
        
        if (number >= A){
            System.out.println(number);
            result ++;
        }
        fourseven(number*10+4); // 4와 7만 있게 하려면 결국 N의 자리가 4 or 7이여야한다.
        fourseven(number*10+7);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str0 = new StringTokenizer(bf.readLine(), " ");
        A = Integer.parseInt(str0.nextToken());
        B = Integer.parseInt(str0.nextToken());
        result = 0;
        fourseven(0);
        System.out.println(result);
    }
}
