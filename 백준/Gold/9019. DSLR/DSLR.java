import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static boolean[] visited;
    static int[] parent; // 이전숫자저장
    static char[] command; // 사용된 명령어 저장

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            parent = new int[10000];
            command = new char[10000];

            bfs(A, B);

            StringBuilder path = new StringBuilder();
            int cur = B;
            while (cur != A) {
                path.append(command[cur]);
                cur = parent[cur];
            }

            sb.append(path.reverse()).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == target) return; // 목표달성!

            // D
            int d = (now * 2) % 10000;
            if (!visited[d]) {
                q.add(d);
                visited[d] = true;
                parent[d] = now;
                command[d] = 'D';
            }

            // S
            int s = (now == 0) ? 9999 : now - 1;
            if (!visited[s]) {
                q.add(s);
                visited[s] = true;
                parent[s] = now;
                command[s] = 'S';
            }

            // L -> 1234 -> 2341 : (234 * 10) + 1
            int l = (now % 1000) * 10 + (now / 1000);
            if (!visited[l]) {
                q.add(l);
                visited[l] = true;
                parent[l] = now;
                command[l] = 'L';
            }

            // R -> 1234 -> 4123 : (4 * 1000) + 123
            int r = (now % 10) * 1000 + (now / 10);
            if (!visited[r]) {
                q.add(r);
                visited[r] = true;
                parent[r] = now;
                command[r] = 'R';
            }
        }
    }
}
