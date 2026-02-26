import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];

        dp[0][0] = Integer.parseInt(br.readLine());
        
        int line = 2;

        StringTokenizer st;
        
        for(int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < line; j++) {
                int num = Integer.parseInt(st.nextToken());
                
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } 
                else if (j == (line - 1)) {
                    dp[i][j] = dp[i - 1][line - 2] + num;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + num, dp[i - 1][j] + num);
                }
            }
            
            line++;
        }
        
        Arrays.sort(dp[n-1]);
        
        System.out.println(dp[n-1][n-1]);
    }
}