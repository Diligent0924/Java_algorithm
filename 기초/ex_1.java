package 기초;

public class ex_1 {
    public static void main(String[] args) {
        int [] result = new int [5];
        for (int i= 0; i < result.length; i++){
            result[i] = i+1;
        }

        int d_result = 0;
        for (int i = 0; i < result.length; i++){
            if(result[i]%2==0){
                d_result += result[i];
            }
        }
        System.out.println(d_result);
    }
}
