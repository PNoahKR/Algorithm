import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
			// N과 M 받기
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] aArr = new int[N];
			int[] bArr = new int[M];

			for (int i = 0; i < N; i++) {
				aArr[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				bArr[i] = sc.nextInt();
			}

			// 로직
			// N과 M을 비교해 작은 쪽을 고정시켜 긴쪽을 범위에 벗어나지 않게 해서 곱의 합을 구해보자!
			// 만일 길이가 같아면 전부 곱해!
			int max = Integer.MIN_VALUE;
			
			if (N > M) {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += aArr[i+j] * bArr[j];
					}
					max = Math.max(max, sum);
				}
			} else {
				for (int i = 0; i < M - N + 1; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += aArr[j] * bArr[i+j];
					}
					max = Math.max(max, sum);
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + max);
		}
	}
}