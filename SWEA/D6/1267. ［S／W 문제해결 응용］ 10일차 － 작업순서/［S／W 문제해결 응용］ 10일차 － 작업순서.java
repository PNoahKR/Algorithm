import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 정점의 개수
			int V = Integer.parseInt(st.nextToken());
			// 간선의 개수
			int E = Integer.parseInt(st.nextToken());
			// 인접리스트 생성
			int[][] adjArr = new int[V+1][V+1];
			// 진입차수 저장 배열
			int[] inDegree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				// 인접리스트 추가
				adjArr[from][to] = 1;
				// 진입차수 추가
				inDegree[to]++;
			}
			
			// 로직
			// 작업순서를 넣을 큐 생성
			Queue<Integer> q = new ArrayDeque<>();
			
			// 진입차수가 0인 정점 넣기
			for (int i = 1; i < V+1; i++) {
				if(inDegree[i] == 0)
					q.add(i);
			}
			
			// q가 공백이 될때 까지 돌리면서 StringBuilder에 담기
			StringBuilder sb = new StringBuilder();
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr).append(" ");
				
				for (int i = 1; i < V+1; i++) {
					if(adjArr[curr][i] == 1) {
						inDegree[i]--;
						if(inDegree[i] == 0) {
							q.add(i);
						}
					}
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + sb);
		}
	}
}
