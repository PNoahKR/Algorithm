import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}
			dist = new int[N][N];

			// 로직
			bfs(arr);

			// 출력
			System.out.println("#" + test_case + " " + dist[N-1][N-1]);
		}
	}

	private static void bfs(int[][] arr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		Queue<int[]> queue = new LinkedList<>();
		
		dist[0][0] = 0;
		queue.add(new int[] {0, 0});
		
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			int r = current[0];
			int c = current[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int newCost = dist[r][c] + arr[nr][nc];
					if(newCost < dist[nr][nc]) {
						dist[nr][nc] = newCost;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
	}
}
