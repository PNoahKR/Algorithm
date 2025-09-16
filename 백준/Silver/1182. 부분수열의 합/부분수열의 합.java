import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S, result;
	static int[] arr, temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정수 N과 S 받기
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		// 수열
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		
		for (int i = 1; i <= N; i++) {
			temp = new int[i];
			comb(0, 0, i);
		}
		
		System.out.println(result);
		
	}
	private static void comb(int idx, int sidx, int size) {		
		if(sidx == size) {
			int sum = 0;
			for (int i : temp) {
				sum += i;
			}
			if(sum == S) result++;
			return;
		}
		
		for (int i = idx; i <= N - size + sidx; i++) {
			temp[sidx] = arr[i];
			comb(i+1, sidx+1, size);
		}
	}
}
