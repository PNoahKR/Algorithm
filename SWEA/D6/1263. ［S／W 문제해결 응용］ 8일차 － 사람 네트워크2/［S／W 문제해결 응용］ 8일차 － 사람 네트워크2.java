import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 사람 수 N
			int N = Integer.parseInt(st.nextToken());
			
			// 플로이드 워셜을 쓸거임. 응 아무래도
			// 네트워크 배열
			int[][] network = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					network[i][j] = INF;
				}
			}
			
			// from - to 가 1 이면 직접 연결인 상태니까 1의 값으로 넣어줍시다.
			// 0 1 1 0 0 / 1 0 1 1 1 / 1 1 0 0 0 / 0 1 0 0 0 / 0 1 0 0 0
			for (int from = 0; from < N; from++) {
				for (int to = 0; to < N; to++) {
					int cost = Integer.parseInt(st.nextToken());
					if(cost == 1) {
						network[from][to] = cost;						
					}
				}
			}
			
			// 배열이 잘 만들어졌나 확인용
//			for(int[] arr : network) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			// 로직
			// 플로이드 워셜을 사용해서 각 정점의 모든 노드로 가는 최단 경로의 합을 구한다음
			// 그 중 최소값을 찾아 출력하면 ㄲ!
			
			// 플로이드 워셜
			for (int k = 0; k < N; k++) {
				for (int from = 0; from < N; from++) {
					if(network[from][k] == INF) continue;
					for (int to = 0; to < N; to++) {
						if(network[k][to] == INF) continue;
						network[from][to] = Math.min(network[from][to], network[from][k] + network[k][to]);
					}
				}
			}
			
			// 배열이 잘 만들어졌나 확인용
//			for(int[] arr : network) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			// 경로의 합 중 최소 값은?
			int minCost = INF;
			
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += network[i][j];
				}
				minCost = Math.min(minCost, sum);
			}
            
			// 출력
			System.out.println("#" + test_case + " " + minCost);
			
		}
	}
}
