import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            LinkedList<Integer> arr = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(new int[] {j, x});
                arr.add(x);
            }
            arr.sort(Comparator.reverseOrder());

            int count = 0;
            int max = arr.poll();

            while (!q.isEmpty()) {
                int[] poll = q.poll();

                if (poll[1] == max && poll[0] == M) {
                    count++;
                    break;
                } else if (poll[1] == max) {
                    count++;
                    max = arr.poll();
                } else {
                    q.offer(poll);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}