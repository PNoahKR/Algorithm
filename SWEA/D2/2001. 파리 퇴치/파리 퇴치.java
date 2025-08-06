
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
			// 파리영역 크기
			int N = sc.nextInt();
			// 파리채 크기
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 로직
			// 잡은 최대 파리수
			int max = 0;
			// 파리 영역 에서 파리채 만큼만 잡기
			// for i = 0, i < N-M+1
			// for j = 0, j < N-M+1
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0; // 현재 위치에서 잡은 파리의 수
					for (int r = 0; r < M; r++) {
						for (int c = 0; c < M; c++) {
							sum += arr[i+r][j+c];
						}
					}
					max = Math.max(max, sum);
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + max);
		}
	}
}