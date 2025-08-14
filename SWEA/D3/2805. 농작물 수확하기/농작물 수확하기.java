
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
			// 농장 크기!
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			// 로직
			// 농장크기에 딱 맞는 정사각형 마름모 형태에 농장크기는 항상 홀수 임으로 다이아몬드 형태의 수확 면적이 생긴다
			// 여기에는 규칙성이 있는데, 첫번째 행의 가운데 부터 1칸 다음칸은 중앙에 3칸 5칸.. N칸 까지 간 다음 역순으로 줄어드느 형태이다
			// 이런 규칙성으로 중앙으로부터 양쪽으로 퍼졌다가 줄어드는 로직을 짜보자
			
			// 수확물
			int sum = 0;
			
			// 중앙행 값
			int mid = N/2;
			// 중앙 행까지 수확 진행!
			for (int i = 0; i <= mid; i++) {
				for (int j = mid - i; j <= mid + i; j++) {
					sum += farm[i][j];
				}
			}
			
			// 중앙 바로 밑 부터 수확 진행!
			for (int i = mid + 1; i < N; i++) {
				for (int j = mid - (N - 1 - i); j <= mid + (N - 1 - i); j++) {
					sum += farm[i][j];
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + sum);
		}
	}
}