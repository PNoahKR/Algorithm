import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int N, result;
	static char[][] grid;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 그리드 크기
		N = Integer.parseInt(br.readLine());
		grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		}
		
		visited = new boolean[N][N];
		boolean gr = false;
		result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result++;
					dfs(i, j, grid[i][j], gr);
				}
			}
		}

		System.out.print(result + " ");

		visited = new boolean[N][N];
		gr = true;
		result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					result++;
					dfs(i, j, grid[i][j], gr);
				}
			}
		}
		
		System.out.println(result);

	}

	private static void dfs(int r, int c, char simbol, boolean gr) {
		if (!gr && grid[r][c] != simbol) {
			return;
		} else if (gr && (simbol == 'G' || simbol == 'R')) {
			if (grid[r][c] == 'B')
				return;
		} else if (grid[r][c] != simbol) return;

		visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				dfs(nr, nc, simbol, gr);
			}
		}

	}
}
