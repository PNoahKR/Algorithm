import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, realFriend;
	static List<Integer>[] friends;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 반 인원수!
			N = Integer.parseInt(st.nextToken());
			// 친친 관계 칭구칭구~
			int M = Integer.parseInt(st.nextToken());
			
			// 학생수는 1 ~ N 까지니까
			friends = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				friends[i] = new ArrayList<>();
			}
			
			// 친친관계 연결하기!
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 친구끼리 서로 양방향 관계
				friends[a].add(b);
				friends[b].add(a);
			}
			
			// 로직
			// 과연 상원이의 진짜 친구는?
			realFriend = 0;
			findRealFriend();
			// 출력
			System.out.println("#" + test_case + " " + realFriend);
		}
	}

	private static void findRealFriend() {
		// bfs탐색을 위한 queue 생성
		Queue<int[]> q = new LinkedList<>();
		// 방문여부를 쳌
		boolean[] visited = new boolean[N+1];
		// 상원이는 1번에 자기 자신임으로 0의 깊이 관계
		int[] sangwon = {1, 0}; // 번호, 깊이
		// q에 상원이를 넣고 관계를 들춰보자
		q.add(sangwon);
		visited[1] = true; // 방문처리
		
		while(!q.isEmpty()) {
			// q에서 번호와 깊이 가져오기
			int[] current = q.poll();
			int idx = current[0];
			int depth = current[1];
			
			// 만약 깊이가 2이상 이면 친한친구아님 ㅠ
			if (depth >= 2) {
				continue;
			}
			// q에선 꺼내온 번호의 친구관계 사이즈만큼 순회
			for (int i = 0; i < friends[idx].size(); i++) {
				// 꺼내온 번호의 친구 관계 중, 방문x이면
				if(!visited[friends[idx].get(i)]) {
					// 방문처리하고 친한친구 +
					visited[friends[idx].get(i)] = true;
					realFriend++;
					// 그리고 그 친한친구의 번호와 깊이+1을 q에 추가해 한단계 더 깊게 들어가기!
					q.add(new int[] {friends[idx].get(i), depth + 1});
				}
			}
		}
		
	}
}
