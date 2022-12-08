package 기초;

public class 문자에서숫자 {
    public static void main(String[] args) {
        int result = 0;
        String example = "123456789";
        char [] nums = example.toCharArray();

        for (int num : nums){
            result += num-48;
        }
        System.out.println(result);
    }
}
