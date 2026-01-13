import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정렬할 수의 개수
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i <N; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }

        System.out.println(sb);
    }
}
