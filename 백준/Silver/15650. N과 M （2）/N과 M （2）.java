import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // 1부터 탐색 시작, 현재 깊이는 0
        dfs(1, 0);

        System.out.println(sb);
    }

    // point 현재 위치에서 탐색을 시작할 숫자 (이전 숫자 + 1)
    // depth 현재까지 선택한 숫자의 개수
    public static void dfs(int point, int depth) {
        // 종료: M개를 모두 골랐을 때
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 오름차순이어야 하므로, 이전에 고른 숫자보다 큰 수(point부터 반복 시작
        for (int i = point; i <= N; i++) {
            arr[depth] = i; // 현재 깊이에 숫자 담기
            
            // i + 1을 넘겨줘서 다음 depth에서는 i보다 큰 숫자만 고르게 함
            dfs(i + 1, depth + 1);
        }
    }
}