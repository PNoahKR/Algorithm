import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        
        // start부터 탐색하여 오름차순을 유지
        for (int i = start; i < N; i++) {
            if (prev != arr[i]) {
                result[depth] = arr[i];
                prev = arr[i];
                dfs(i, depth + 1); 
            }
        }
    }
}