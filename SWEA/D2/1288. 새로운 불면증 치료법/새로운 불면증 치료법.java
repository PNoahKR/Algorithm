import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			// 배수 입력 받기
			int N = Integer.parseInt(br.readLine());
			int K = 0;
			//숫자를 체크할 배열과 변수 생성
			boolean[] check = new boolean[10];
			int checkNum = 10;
			
			// while문으로 모든 숫자를 볼 때 까지 확인
			while(checkNum > 0) {
				// K 늘리기
				K++;
				
				int KN = N * K;
				String st = String.valueOf(KN);
				
				for (int i = 0; i < st.length(); i++) {
					int num = st.charAt(i) - '0';
					if(!check[num]) {
						check[num] = true;
						checkNum--;
					}
				}
			}
			
			System.out.println("#" + test_case + " " + K * N);
		}
	}
}
