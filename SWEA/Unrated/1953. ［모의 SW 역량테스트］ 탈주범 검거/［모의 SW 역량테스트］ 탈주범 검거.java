import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, R, C, L, result;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] map;
	// 파이프 타입에 따라 가능한 움직임
	static int[][] pipeType = { {}, // 0번 타입 없음
			{ 1, 1, 1, 1 }, // 1: 상하좌우
			{ 1, 1, 0, 0 }, // 2: 상하
			{ 0, 0, 1, 1 }, // 3: 좌우
			{ 1, 0, 0, 1 }, // 4: 상우
			{ 0, 1, 0, 1 }, // 5: 하우
			{ 0, 1, 1, 0 }, // 6: 하좌
			{ 1, 0, 1, 0 } // 7: 상좌
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// N : 지도 세로 크기, M : 지도 가로 크기, R : 맨홀뚜껑 세로 위치, C : 맨홀뚜껑 가로 위치, L : 소요시간
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			// 지도 생성
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 로직
			// bfs탐색을 통해 소요시간내의 도착한 지점이 있을때 result에 +1
			result = 0;
			bfs(R, C);

			// 출력
			System.out.println("#" + test_case + " " + result);

		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[N][M];

		q.add(new int[] { r, c, 1 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			int time = cur[2];

			if (time > L)
				continue;
			result++;
			// 현재 파이프의 종류
			int curPipe = map[curR][curC];

			for (int d = 0; d < 4; d++) {
				// [파이프의 종류][상,하,좌,우 중 하나]의 움직임이 가능하면
				if (pipeType[curPipe][d] == 1) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					// 경계, 방문, 파이프 유무 확인
					if (check(nr, nc)) {
						// 상 하 좌 우 의 경우에 다음 파이프에도 길이 있는지 확인하는 switch문
						switch (d) {
						case 0:
							if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc, time + 1 });
							}
							break;
						case 1:
							if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc, time + 1 });
							}
							break;
						case 2:
							if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc, time + 1 });
							}
							break;
						case 3:
							if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc, time + 1 });
							}
							break;
						default:
							break;
						}
					}
				}
			}
		}
	}

	// 진행 가능한지 체크
	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] > 0) {
			return true;
		}
		return false;
	}
}
