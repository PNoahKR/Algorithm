import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static long[][] dp;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 지도의 크기 N M 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 지도
		map = new int[N][M];
		dp = new long[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // 방문하지 않았음을 표기
			}
		}

		System.out.println(dfs(0, 0));

	}

	private static long dfs(int i, int j) {
		// 종료 조건 : 도착 지점에 왔다면 경로 1 반환
		if(i == N-1 && j == M - 1) return 1;
		
		// -1이 아니면 방문한곳임!
		if(dp[i][j] != -1) {
			return dp[i][j];
		}
		
		// 현 위치는 방문한거니까 0으로 초기화! 
		dp[i][j] = 0;

		// 현재 지점의 높이
		int curPoint = map[i][j];
		// 상하좌우 델타 탐색 ㄱㄱ
		for (int d = 0; d < 4; d++) {
			int nr = i + dx[d];
			int nc = j + dy[d];
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && curPoint > map[nr][nc]) {
				// 현재 경로에 도착점까지의 경로 추가
				dp[i][j] += dfs(nr, nc);
			}
		}
		
		return dp[i][j];
	}
}
