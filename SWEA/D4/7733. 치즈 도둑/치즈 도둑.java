import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, maxDay;
	static boolean[][] visited;
	static int[][] cheeze;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 치즈 한변의 길이 N
			N = Integer.parseInt(br.readLine());
			cheeze = new int[N][N];
			// 최대일수 -> 치즈의 맛보다 날짜가 커지면 의미가 없다!
			maxDay = 0;
	
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cheeze[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(cheeze[i][j], maxDay);
				}
			}

			// 로직
			// 전체 그래프를 maxDay만큼 순회하면서 dfs을 진행
			// 방문하지 않았으며, 치즈의 맛이 day보다 클때 dfs진행
			// dfs 진행을 하게 되면 덩어리 count + 1

			// 덩어리 수 체크
			int maxCheeze = 0;
			
			for (int day = 0; day < maxDay; day++) {
				// 방문처리 boolean 초기화
				visited = new boolean[N][N];
				// 날짜별 덩어리 수
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 방문하지 않은 곳 && day 보다 큰 수가 있는 곳!
						if (!visited[i][j] && cheeze[i][j] > day) {
							dfs(i, j, day);
							count++;
						} // if 조건문
					} // j for
				} // i for
				// maxCheeze와 값을 비교해서 더 큰 값으로 대체
				maxCheeze = Math.max(count, maxCheeze);
			}

			// 출력
			System.out.println("#" + test_case + " " + maxCheeze);
		}
	}

	private static void dfs(int r, int c, int day) {
		// 방문 처리
		visited[r][c] = true;
		// 델타탐색을 하면서 이어진곳은 모두 dfs를 돌려 방문처리
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 경계 밖을 안벗어 나면서 방문도 안하고 치즈의 맛이 날짜보다 높을때
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheeze[nr][nc] > day) {
				dfs(nr, nc, day);
			}
		}
	}
}
