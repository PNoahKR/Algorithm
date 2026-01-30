import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] board;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리
        int M = Integer.parseInt(st.nextToken()); // 뱀

        board = new boolean[101]; // 보드판
        arr = new int[101]; // 사다리 & 뱀

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a] = b;
        }

        bfs(1);
    }

    private static void bfs(int cur) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {cur, 0});
        board[cur] = true;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();

            if(q[0] == 100) {
                System.out.println(q[1]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = q[0] + i;
                if (next <= 100) {
                    if (arr[next] != 0) {
                        next = arr[next];
                    }
                    if (!board[next]) {
                        board[next] = true;
                        queue.add(new int[] {next, q[1] + 1});
                    }
                }
            }
        }
    }
}
