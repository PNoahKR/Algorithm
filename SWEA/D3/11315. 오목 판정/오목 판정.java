import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N;
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		// 입력
			// 오목판 길이 받기
			N = sc.nextInt();
			char[][] arr = new char[N][N];

			// 돌 놓기
			for (int i = 0; i < N; i++) {
				// 한줄을 통째로 받고
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					// 하나씩 char형으로 넣기
					arr[i][j] = str.charAt(j);
				}
			}

			// 로직
			String ans = "NO";
			// 전체 배열을 순회해보자!
			// 배열을 순회하면서 돌(o)을 만나면 델타배열을 활용해 연속되는지 확인해보자!
			// 델타배열중 한 방향으로 차근차근 진행하면서 5목이 되면 바로 조건 완료!
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 'o' && findOmok(arr, i, j)) {
						ans = "YES";
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + ans);
		}
	}
    public static boolean findOmok(char[][] arr, int i, int j) {
		for (int delta = 0; delta < 8; delta++) {
			for (int m = 1; m < 5; m++) {
				int nr = i + (dr[delta] * m);
				int nc = j + (dc[delta] * m);
				// 경계를 벗어나는지!
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || arr[nr][nc] != 'o') {
					break;
				}
				if(m == 4) {
					return true;
				}
			} // 거리 이동 반복문
		}// 델타 방향 전환 반복문
		return false;
	}
}