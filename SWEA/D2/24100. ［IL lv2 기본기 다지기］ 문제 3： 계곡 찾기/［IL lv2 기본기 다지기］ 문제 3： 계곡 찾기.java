/////////////////////////////////////////////////////////////////////////////////////////////

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
			// 계곡의 개수
			int valley = 0;
			// 델타배열을 이용해 상하좌우가 나보다 높다면, 계곡 + 1
			// 가장자리는 탐색하지 않으니 탐색 범위는 1 -> N-1
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < N-1; j++) {
					boolean found = true;
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if(map[nr][nc] <= map[i][j]) {
							found = false;
							break;
						}
					}
					if(found) {
						valley++;
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + valley);
		}
	}
}