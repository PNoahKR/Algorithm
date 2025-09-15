import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Solution {
	static BigInteger[] dp = new BigInteger[251]; // N의 범위는 250까지니까
	static {
		// 초기 값 세팅
		dp[0] = BigInteger.valueOf(0);
		dp[1] = BigInteger.valueOf(1);
		dp[2] = BigInteger.valueOf(3);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			// 2 * N의 N
			int N = Integer.parseInt(br.readLine());

			// 로직
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
			}

			// 출력
			System.out.println("#" + test_case + " " + dp[N]);

		}
	}
}
