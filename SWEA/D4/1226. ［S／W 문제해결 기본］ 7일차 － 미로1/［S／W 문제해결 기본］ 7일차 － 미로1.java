import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int tc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 0; test < 10; test++) {
			tc = Integer.parseInt(br.readLine());
			map = new int[16][16];
			int[] start = null;
			int[] end = null;

			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					if (map[i][j] == 2) {
						start = new int[] { i, j };
					} else if (map[i][j] == 3) {
						end = new int[] { i, j };
					}
				}
			}

			bfs(start[0], start[1], end[0], end[1]);
		}
	}

	private static void bfs(int r, int c, int ex, int ey) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[16][16];

		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == ex && cur[1] == ey) {
				System.out.println("#" + tc + " " + 1);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = cur[0] + dr[i];
				int nc = cur[1] + dc[i];
				if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && map[nr][nc] != 1) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
		System.out.println("#" + tc + " " + 0);

	}
}
