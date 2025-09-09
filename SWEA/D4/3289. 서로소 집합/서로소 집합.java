import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	// 서로소 집합을 표현할 대표자를 가리키는 parent 배열 선언
	static int[] parent;

	// 초기화 make-set : 나 자신을 부모로 가리키도록 초기화 메서드 선언
	static public void init(int N) { // 요소의 개수가 n개일 때 초기화
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	// find-set : 대표자를 반환하는 메서드 선언
	static public int findSet(int x) {
		if (x == parent[x])
			return x;
		// 재귀 호출로 부모를 통해 다시 대표자 탐색 진행
		return parent[x] = findSet(parent[x]);
	}

	// union : x 와 y 가 속해있는 그룹을 통합하는 메서드
	static public void union(int x, int y) {
		int root_x = findSet(x);
		int root_y = findSet(y);
		parent[root_y] = root_x;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력

			// 원소의 개수 N, 연산 개수 M
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 연산 개수 M만큼 입력이 주어짐
			int[][] commands = new int[M][3];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int command = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				commands[i][0] = command;
				commands[i][1] = x;
				commands[i][2] = y;
			}

			// 로직
			// 서로소 집합 생성 후 연산에 따라 처리 후 결과 생성
			StringBuilder sb = new StringBuilder();
			
			init(N+1);
			
			//명령 수행
			for (int i = 0; i < M; i++) {
				int command = commands[i][0];
				int x = commands[i][1];
				int y = commands[i][2];
				if(command == 0) {
					union(x, y);
				}
				else if(command == 1) {
					if(findSet(x) == findSet(y)) sb.append(1);
					else sb.append(0);
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + sb);
		}
	}
}
