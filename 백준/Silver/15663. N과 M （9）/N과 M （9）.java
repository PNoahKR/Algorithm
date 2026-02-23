import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] count = new int[10001]; // 카운팅 배열
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {

        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 10000까지 탐색
        for (int i = 1; i <= 10000; i++) {
            
            if (count[i] > 0) {
                count[i]--;
                result[depth] = i;
                dfs(depth + 1);
                count[i]++;
            }
        }
    }
}