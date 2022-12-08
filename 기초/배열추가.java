package 기초;

public class 배열추가 {
    public static void main(String[] args) {
        int [] score = {90,80,100};
        int [] count = new int[101];
        int min = Integer.MAX_VALUE;
        for (int i : score){
            if(i < min){
                min = i;
            }
            count[i]++;
        }
        System.out.println(min);
        System.out.println(count[100]);
    }
}
