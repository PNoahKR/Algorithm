import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[][][][] dp;
    static int[] fact = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        fact[0] = 1;
        for (int i = 1; i <= 10; i++) {
            fact[i] = fact[i - 1] * i;
        }

        dp = new long[N + 1][R + 1][G + 1][B + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= R; j++) {
                for (int k = 0; k <= G; k++) {
                    for (int l = 0; l <= B; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        System.out.println(solve(1, R, G, B));
    }

    static long solve(int level, int r, int g, int b) {
        if (level > N) {
            return 1;
        }

        if (dp[level][r][g][b] != -1) {
            return dp[level][r][g][b];
        }

        long count = 0;

        if (r >= level) count += solve(level + 1, r - level, g, b);
        if (g >= level) count += solve(level + 1, r, g - level, b);
        if (b >= level) count += solve(level + 1, r, g, b - level);

        if (level % 2 == 0) {
            int req = level / 2;
            long ways = calcCombination(level, req, req, 0);

            if (r >= req && g >= req) count += ways * solve(level + 1, r - req, g - req, b);
            if (r >= req && b >= req) count += ways * solve(level + 1, r - req, g, b - req);
            if (g >= req && b >= req) count += ways * solve(level + 1, r, g - req, b - req);
        }

        if (level % 3 == 0) {
            int req = level / 3;
            long ways = calcCombination(level, req, req, req);

            if (r >= req && g >= req && b >= req) {
                count += ways * solve(level + 1, r - req, g - req, b - req);
            }
        }

        return dp[level][r][g][b] = count;
    }

    private static long calcCombination(int n, int a, int b, int c) {
        return fact[n] / (fact[a] * fact[b] * fact[c]);
    }
}