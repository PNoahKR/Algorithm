import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int[] board, visited;
	static int count, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			N = Integer.parseInt(br.readLine());

			// 로직
			board = new int[N];
			visited = new int[N];
			count = 0;
			
			bfs(0);
			
			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}

	private static void bfs(int row) {
		// 종료 조건
		if(row == N) {
			count++;
			return;
		}
		
		for (int col = 0; col < N; col++) {
			if(isPromising(row, col)) {
				visited[row] = col;
				bfs(row + 1);
				
			}
		}
		
	}

	private static boolean isPromising(int row, int col) {
		for (int i = 0; i < row; i++) {
			if(visited[i] == col) return false;
			if(Math.abs(row-i) == Math.abs(col-visited[i])) return false;
		}
		return true;
	}


}
