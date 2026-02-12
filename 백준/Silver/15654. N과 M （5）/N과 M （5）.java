import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        loop(0);

        System.out.println(sb);
    }

    private static void loop(int depth) {
        if (depth == m) {
            for (int val : tmp) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            // 이미 방문한(뽑은) 숫자는 패스
            if (!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                loop(depth + 1);
                visited[i] = false;
            }
        }
    }
}