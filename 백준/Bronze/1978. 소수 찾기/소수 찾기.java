import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어질 수 개수 
		int N = Integer.parseInt(br.readLine());
		// 주어지는 수 배열
		int[] arr = new int[N];
		// 주어지는 수 중 가장 큰 값
		int max = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		
		// 소수를 판별하기 위한 최대값까지의 수를 담을 배열
		// 소수는 0 소수가 아닌 수는 1
		int[] number = new int[max+1];
		// 0, 1은 소수가 아님
		number[0] = number[1] = 1;
		// 소수 판변
		for (int i = 2; i <= max; i++) {
			// 만약 i가 소수이면
			if(number[i] == 0) {
				// 배수계산을 이어갈 변수
				int multi = 2;
				// i의 2, 3, 4, ... 배수는 소수 제외
				while((i * multi) <= max) {
					number[i*multi] = 1;
					multi++;
				}
			}
		}
		
		// 소수 카운트
		int primeCount = 0;
		for (int i = 0; i < N; i++) {
			// 배열의 수가 소수면 카운트 업
			if(number[arr[i]] == 0) primeCount++;
		}
		
		System.out.println(primeCount);
	}
}
