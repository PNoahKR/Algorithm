import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 게임판의 크기 N
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 처음에 재귀적으로 해볼라했는데... N이 100이 넘어가니 당연히 시간초과가 났다.
		// DP 방법으로 하려면 어떻게 해야할까?
		
		// dp 배열을 만들어 0,0의 위치가 시작 점이니 1가지 방법으로 이미 도착해있다. 라고 가정하고 미리 입력해준다.
		long[][] dp = new long[N][N];
		
		dp[0][0] = 1;
		
		// 이후 1이 있는 시작점 부터 오른쪽, 아래로 점프해서 갈 수 있는 칸들에 1을 누적시킨다.
		// 이렇게 되면 	시작점에서 부터 점프할 수 있는 곳에만 1이 쌓일 것이고.
		// 1을 경우의 수이니 누적되면서 마지막 도착점에 모든 경우의 수가 더해져 도착점까지 갈 수 있는 경우의 수가 완성된다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int next = board[i][j];
				// 칸에 적혀있는 수는 (0<= X <= 9) 
				if(next == 0) continue;
				// 보드의 범위 내라면 기록!
				if(i + next < N) dp[i+next][j] += dp[i][j];
				if(j + next < N) dp[i][j+next] += dp[i][j];
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
		
	}
}
