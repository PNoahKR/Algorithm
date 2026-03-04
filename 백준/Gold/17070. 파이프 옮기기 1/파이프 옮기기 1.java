import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n + 1][n + 1];
        
        // dir -> 0: 가로, 1: 세로, 2: 대각선
        long[][][] dp = new long[n + 1][n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        // 처음에 파이프는 (1, 1), (1, 2)를 차지하고 있고, 끝은 (1, 2)에 가로(0)로 놓여있음
        dp[1][2][0] = 1;

        // 파이프는 우측, 하단으로만 이동하므로 열(j)은 3부터 시작해도 무방함
        // (1, 2)에서 가로로 시작하기 때문에 1열과 2열 아래쪽으로는 절대 갈 수 없기 때문!
        for (int i = 1; i <= n; i++) {
            for (int j = 3; j <= n; j++) {
                
                // 현재 칸이 벽(1)이면 파이프가 올 수 없음
                if (map[i][j] == 1) continue;

                // 가로: 이전 칸(i, j-1)이 가로 or 대각선
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                // 세로: 이전 칸(i-1, j)이 세로 or 대각선
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                // 대각선: 위쪽(i-1, j)과 왼쪽(i, j-1) 모두 벽이 아니어야 함!
                if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        // (N, N)에 가로, 세로, 대각선으로 도달한 모든 경우의 수를 더함
        long result = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(result);
    }
}