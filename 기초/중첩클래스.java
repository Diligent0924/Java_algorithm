package 기초;

import java.io.IOException;
public class 중첩클래스 {
    static int sum(int a, int b){
        return a + b;
    }

    public static void main(String[] args) throws IOException{
        int a = System.in.read();
        System.in.read();
        System.out.println(a);
        int b = sum(a,a);
        System.out.println(b);
    }
}
