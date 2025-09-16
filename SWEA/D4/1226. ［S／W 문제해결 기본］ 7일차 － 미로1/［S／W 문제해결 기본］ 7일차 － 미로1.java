import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] miro = new int[16][16]; // 미로의 크기 (매번 전체 초기화가 된다)
	static boolean[][] visited;
	static boolean finished;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {

			// 입력
			// 테스트 케이스 번호
			int tc = Integer.parseInt(br.readLine());
			// 미로 입력을 받으면서 출발점과 도착점 찾기
			int[] start = null;
			int[] end = null;
			for (int i = 0; i < 16; i++) {
				String line = br.readLine(); // 한줄 받아오기
				for (int j = 0; j < 16; j++) {
					miro[i][j] = line.charAt(j) - '0';
					// 출발점과 도착점 찾기
					if (miro[i][j] == 2) {
						start = new int[] { i, j };
					} else if (miro[i][j] == 3) {
						end = new int[] { i, j };
					}
				}
			}

			// 로직
			// visited는 매번 초기화 해주자
			visited = new boolean[16][16];
			// 도달했는가?
			finished = false;
			// DFS탐색을 하면서 3을 만나면 1을 출력, 만나지 못한다면 0을 출력하게 한다.
			visited[start[0]][start[1]] = true;
			dfs(start, end);

			// 출력
			if(finished) System.out.println("#" + tc + " " + 1);
			else System.out.println("#" + tc + " " + 0);

		}
	}

	private static void dfs(int[] cur, int[] end) {
		// 종료 조건
		// 도착지점에 도달하면 1 출력 후 반환
		if(cur[0] == end[0] && cur[1] == end[1]) {
			finished = true;
			return;
		} 
		// 이미 결과에 도달함
		else if(finished) {
			return;
		}
		
		
		//재귀
		for (int d = 0; d < 4; d++) {
			int nr = cur[0] + dr[d];
			int nc = cur[1] + dc[d];
			if(check(nr, nc)) {
				visited[nr][nc] = true;
				dfs(new int[] {nr,nc}, end);
				visited[nr][nc] = false;
			}
		}
	}

	// 진행 가능한지 체크
	private static boolean check(int nr, int nc) {
		if(nr >= 0 && nr < 16 && nc >= 0 && nc < 16 && !visited[nr][nc] && miro[nr][nc] != 1) {
			return true;
		}
		return false;
	}
}
