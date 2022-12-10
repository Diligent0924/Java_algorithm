package 기초;
import java.util.ArrayList;


public class 자바어레이 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Black"); // append와 같은 개념
        colors.add(0,"White"); // 앞에 인덱스 위치를 붙일 수 있음.
        System.out.println(colors.get(0)); // index로 받아들이기 위해서는 이렇게 사용
        for (String color : colors){ // 각각을 받아서 사용하는 것도 가능하다.
            System.out.println(color);
        }
        System.out.println(colors.contains("Black")); // bool형태로 있는지 없는지 확인이 가능하다.
        System.out.println(colors.indexOf("Black")); // Black의 index를 알려준다.
        String a = colors.remove(0); // index로 삭제 가능하다.(변수 형태로 받을 수도 있다.)
        System.out.println(a); // remove를 index로 제거할 경우에 바로 받아서 쓸 수 있다.
        System.out.println(colors.get(0)); // index로 받아들이기 위해서는 이렇게 사용
        
        // 이차원에서는 어떻게 사용되는가?
        ArrayList<Integer>[] graph = new ArrayList[3]; 
        for (int i = 0; i<3 ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j<3; j++){
                graph[i].add(1);
            }
        }
        System.out.println(graph[0]);

        // 고정된 2차원 배열
        int N = 10;
        int [][] graph_2 = new int [N][N];
        System.out.println(graph_2[0][0]);
    }
}
