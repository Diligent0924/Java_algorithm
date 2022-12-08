package Bronze;
import java.io.IOException;
public class plus {
    public static void main(String[] args) throws IOException{
        int a = System.in.read(); // 첫번째 데이터를 받는다.
        System.in.read(); // 이거 왜 해줘야 하는지 잘 모르겠음.
        int b = System.in.read();
        System.in.read();
        a = a - 48;
        b = b - 48;
        System.out.println(a+b);
    }
}
