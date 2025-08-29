import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;
    
    // 좌표와 시간을 관리할 객체
	static class Point {
		int r, c, time;

		public Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
    
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			// 입력
			// 지도 정보
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			visited = new boolean[N][M];

			Queue<Point> sooyeonQueue = new LinkedList<>();
			Queue<Point> devilQueue = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == 'S') {
						sooyeonQueue.add(new Point(i, j, 0));
						visited[i][j] = true;
					} else if (map[i][j] == '*') {
						devilQueue.add(new Point(i, j, 0));
					}
				}
			}

			int result = bfs(sooyeonQueue, devilQueue);

			if (result == -1) {
				System.out.println("#" + test_case + " GAME OVER");
			} else {
				System.out.println("#" + test_case + " " + result);
			}


		}
	}
    public static int bfs(Queue<Point> sooyeonQueue, Queue<Point> devilQueue) {
		while (!sooyeonQueue.isEmpty()) {
			// 악마의 손아귀 스킬 발동
			int devilSize = devilQueue.size();
			for (int i = 0; i < devilSize; i++) {
				Point currentDevil = devilQueue.poll();
				for (int j = 0; j < 4; j++) {
					int nr = currentDevil.r + dr[j];
					int nc = currentDevil.c + dc[j];
					if (nr < N && nr >= 0 && nc < M && nc >= 0) {
						if (map[nr][nc] != 'D' && map[nr][nc] != 'X' && map[nr][nc] != '*') {
							map[nr][nc] = '*';
							devilQueue.add(new Point(nr, nc, 0));
						}
					}
				}
			} // 악마의 손아귀 끝

			// 수연이 이동 고
			int sooyeonSize = sooyeonQueue.size();
			for (int i = 0; i < sooyeonSize; i++) {
				Point sooyeon = sooyeonQueue.poll();
				for (int j = 0; j < 4; j++) {
					int nr = sooyeon.r + dr[j];
					int nc = sooyeon.c + dc[j];
					if (nr < N && nr >= 0 && nc < M && nc >= 0 && !visited[nr][nc]) {
						if (map[nr][nc] == 'D') {
							return sooyeon.time + 1;
						}

						if (map[nr][nc] == '.') {
							visited[nr][nc] = true;
							sooyeonQueue.add(new Point(nr, nc, sooyeon.time + 1));
						}
					}
				}
			} // 수연이 이동 끝
		}
		return -1;
	}
}