import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static Stack<Integer> result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			// 학생수
			N = Integer.parseInt(st.nextToken());
			// 순서의 개수
			M = Integer.parseInt(st.nextToken());
			
			// 유향 그래프
			adjList = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			visited = new boolean[N+1];
			result = new Stack<>();
			int[] inDegree = new int[N+1];
			
			// 그래프 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
				inDegree[to]++;
			}
			
			
			// 로직
			for(int i = 1; i < N+1; i++) {
				if(inDegree[i] == 0)
					dfs(i);
			}
			
			StringBuilder sb = new StringBuilder();
			while(!result.isEmpty()) {
				sb.append(result.pop()).append(" ");
			}
			
			// 출력
			System.out.println("#" + test_case + " " + sb);
		}
	}

	private static void dfs(int v) {
		visited[v] = true;
		
		for(int to : adjList[v]) {
			if(!visited[to])
				dfs(to);
		}
		
		result.push(v);
	}
}
