/**
 * hello
 */
import java.io.IOException;
public class hello {
    public static void main(String[] args) throws IOException{
        // int a = System.in.read();
        // System.in.read();
        // int b = System.in.read();
        // System.in.read();
        // a = a - 48;
        // b = b - 48;
        // System.out.println(a+b);
        int [] points = new int[3];
        System.out.println(points.length);
        System.out.println(points[0]);
        for (int i = 0; i<points.length;i++){
            points[i] = i+1;
        }
        for (int i = 0; i<points.length;i++){
            System.out.println(points[i]);
        }
    }
}