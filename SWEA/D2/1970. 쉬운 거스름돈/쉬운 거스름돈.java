import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static final int[] WON = { 10, 50, 100, 500, 1000, 5000, 10000, 50000 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			// 금액 입력 받기
			int N = Integer.parseInt(br.readLine());

			// 로직
			StringBuilder sb = new StringBuilder();
			for (int i = WON.length - 1; i >= 0; i--) {
				int value = N / WON[i];
				N %= WON[i];
				sb.append(value).append(" ");
			}
			
			// 출력
			System.out.println("#" + test_case);
			System.out.println(sb);

			
			//////////////////화폐의 최소 개수 구하기(연습겸)///////////////////////////////
//			// 점화식으로 만들 dp 테이블 생성
//			int[] dp = new int[N + 1];
//			Arrays.fill(dp, Integer.MAX_VALUE);
//			dp[0] = 0; // 0원은 0개
//
//			// 로직
//			// down-top방식으로 순서대로 최소 개수를 구해가자
//			// 최소 10원 단위니까 10씩 올려도 될듯?
//			for (int i = 1; i <= N; i ++) {
//				// WON에서 하나씩 해보자
//				for (int w : WON) {
//					if(i >= w) {
//						dp[i] = Math.min(dp[i], dp[i - w] + 1);
//					}
//				}
//			}
//
//			// 출력
//
//			System.out.println("#" + test_case + " " + dp[N]);

		}
	}
}
