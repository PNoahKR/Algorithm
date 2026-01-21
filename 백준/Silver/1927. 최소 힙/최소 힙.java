import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());

            if(cmd == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(cmd);
            }
        }

        System.out.println(sb);
    }
}
