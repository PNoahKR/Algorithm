
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    // 상하좌우 델타배열
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
    
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
			// 맵 크기
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 로직
			// 산 봉우리 개수
			int peaks = 0;
			// 델타배열을 이용해 상하좌우가 나보다 높다면, 봉우리 + 1
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean found = true;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							if (map[nr][nc] >= map[i][j]) {
								found = false;
								break;
							}
						}
					}
					if (found) {
						peaks++;
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + peaks);
		}
	}
}