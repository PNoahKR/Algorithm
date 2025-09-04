import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, max;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };
	static boolean[] desserts;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 카페거리 크기 n
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			// 카페의 디저트 종류 입력
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 로직
			// 최대 카페 수
			max = -1;
			// 디저트 먹은거 초기화 (1~100 까지의 수)
			// 방문처리를 이걸로 대신한다. 같은 종류의 디저트 중복도 체크해주면서 -> 지나온 길 디저트도 표시가 되니까
			// visited의 역할도 동시에 해낸다.
			desserts = new boolean[101];
			cafeGoGo();

			// 출력
			System.out.println("#" + test_case + " " + max);
		}
	}

	public static void cafeGoGo() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 모든 정점에서 사각형을 만들어보자
				// 시작점 디저트 냠냠
				desserts[map[i][j]] = true;
				// 시작점으로 부터 탐색 시작 (시작점r, 시작점c, 현재위치r, 현재위치c, 방향d, 디저트카페개수count)
				dfs(i, j, i, j, 0, 0);
				// 시작점 디저트 뱉뱉
				desserts[map[i][j]] = false;
			}
		}
	}

	public static void dfs(int startR, int startC, int r, int c, int d, int count) {
		// 직진
		int nr = r + dr[d];
		int nc = c + dc[d];
		// 다음 갈 곳이 시작점과 같다면 값 비교해보고 반환
		if (nr == startR && nc == startC) {
			max = Math.max(max, count + 1);
			return;
		}
		// 경계값 과 먹은 디저트인지 체크
		if (check(nr, nc) && !desserts[map[nr][nc]]) {
			// 다음 디저트 냠냠
			desserts[map[nr][nc]] = true;
			// 카페 개수를 + 1 방향은 그대로! 
			dfs(startR, startC, nr, nc, d, count + 1);
			// 다음 디저트 뱉뱉
			desserts[map[nr][nc]] = false;
		}

		// 오른쪽으로 전환 (최대 3까지) -> 아니면 달팽이가 될수도..
		if(d < 3) {
			nr = r + dr[d + 1];
			nc = c + dc[d + 1];
			// 다음 갈 곳이 시작점과 같다면 값 비교해보고 반환
			if (nr == startR && nc == startC) {
				max = Math.max(max, count + 1);
				return;
			}
			if (check(nr, nc) && !desserts[map[nr][nc]]) {
				desserts[map[nr][nc]] = true;
				dfs(startR, startC, nr, nc, d + 1, count + 1);
				desserts[map[nr][nc]] = false;
			}
		}
	}

	public static boolean check(int r, int c) {
		if (r >= 0 && r < N && c >= 0 && c < N)
			return true;
		return false;
	}
}