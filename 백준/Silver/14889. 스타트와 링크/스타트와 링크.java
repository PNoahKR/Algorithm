import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, team, min;
	static int[][] stats;
	static boolean[] visited;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 인원수 N명
		N = Integer.parseInt(br.readLine());
		// 1~N명 까지니까~
		stats = new int[N+1][N+1];
		
		// 스탯 분배하기
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// N/2 팀인원수
		team = N / 2;
		
		// start, link 팀을 구별할 배열
		visited = new boolean[N+1];
		
		// 능력치 최소 차이
		min = Integer.MAX_VALUE;
		
		comb(1,0);
		
		System.out.println(min);
	}


	private static void comb(int idx, int sidx) {
		// 종료
		if(sidx == team) {
			int sSum = 0;
			int lSum = 0;
			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					if(visited[i] && visited[j]) {
						sSum += stats[i][j] + stats[j][i];
					}
					else if (!visited[i] && !visited[j]) {
						lSum += stats[i][j] + stats[j][i];
					}
				}
			}
			
			min = Math.min(min, Math.abs(sSum - lSum));
			return;
		}
		
		if(idx == N) return;
		
		// idx가 스타트팀일때
		visited[idx] = true;
		comb(idx + 1, sidx+1);
		
		// idx가 링크팀일때
		visited[idx] = false;
		comb(idx + 1, sidx);
		
	}
}
