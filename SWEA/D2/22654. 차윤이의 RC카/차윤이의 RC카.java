import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			// 입력
			// 공원 정보 입력받기
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			int[] car = null;

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'X') {
						car = new int[] { i, j };
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			
			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				int dir = 0; // 바라보는 방향
				int r = car[0];
				int c = car[1];
				st = new StringTokenizer(br.readLine());
				int C = Integer.parseInt(st.nextToken());
				char[] cmd = st.nextToken().toCharArray();
				for (int j = 0; j < C; j++) {
					char action = cmd[j];
					if(action == 'A') {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if(nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] != 'T') {
							r = nr;
							c = nc;
						}
					}
					else if (action == 'L') {
						dir = (dir + 3) % 4;
					}
					else if (action == 'R') {
						dir = (dir + 1) % 4;
					}
				}
				if(map[r][c] == 'Y') {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			
			System.out.println("#" + test_case + " " + sb);
		}
	}
}
