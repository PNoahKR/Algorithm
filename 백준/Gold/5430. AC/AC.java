import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            String input = br.readLine();
            if (n > 0) {
                st = new StringTokenizer(input, "[],");
                for (int i = 0; i < n; i++) {
                    deque.addLast(Integer.parseInt(st.nextToken()));
                }
            }

            boolean left = true; // true = 정방향, false = 역방향
            boolean error = false;

            for (int i = 0; i < p.length(); i++) {
                char command = p.charAt(i);
                if (command == 'R') {
                    left = !left;
                } else { // 'D'
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (left) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (!error) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(left ? deque.pollFirst() : deque.pollLast());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}