import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 거리의 길이

        // [][] 배열로 [거리][색 비용]으로 누적 비용을 계산하는 DP문제
        // 0: 빨  1: 초  2:파
        int[][] dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }

        // N개의 집 누적 계산 (첫번째는 초기 값이기 때문에 패스)
        for(int i = 1; i < N; i++) {
            // i번째 집이 빨강일때, 이전 집은 초록 또는 파랑 중 최소 비용 선택
            dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
        }

        // 마지막 집의 최소값을 출력
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}