/**
 * hello
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class hello {
    public static void main(String[] args) throws IOException{
        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        a.add("1");
        a.add("2");
        b.add("1");
        for (String i : a){
            System.out.println(i);
        }
        System.out.println(a.indexOf("1"));
        // String k = new String(a);
        System.out.println(b);
        System.out.println(a==b);
        System.out.println("a" == "a");

        String bb = "abcd";
        System.out.println(bb.charAt(1));
    }
}