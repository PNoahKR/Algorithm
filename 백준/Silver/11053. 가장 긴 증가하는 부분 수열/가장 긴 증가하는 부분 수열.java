import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 기본적으로 자기 자신만 포함하므로 1

            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            
            if (maxLen < dp[i]) {
                maxLen = dp[i];
            }
        }

        System.out.println(maxLen);
    }
}