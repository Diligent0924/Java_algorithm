// BigInteger라는 개념에 대해서 알 수 있었다.
package 실버.실버3;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * BOJ2497
 */
public class BOJ2497 {
    private static int n, m;

    static BigInteger combination(int h){
        BigInteger count = new BigInteger("1");
        for (int i = 2; i < h+1; i++) {
            count = count.multiply(new BigInteger(String.valueOf(i)));
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str0 = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(str0.nextToken());
        m = Integer.parseInt(str0.nextToken());
        BigInteger up = combination(n);
        BigInteger down = combination(m).multiply(combination(n-m));
        BigInteger result = up.divide(down);
        System.out.println(result);
    }
}