import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 창용 마을 사람 수
			int N = Integer.parseInt(st.nextToken());
			// 관계 수
			int M = Integer.parseInt(st.nextToken());

			// 로직
			// 서로소 집합 초기화
			int[] parent = new int[N + 1];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				union(parent, x, y);
			}

			// 무리 개수 확인
			int count = 0;
			Set<Integer> groups = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				groups.add(find(parent, i));
			}

			count = groups.size();

			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}

	private static void union(int[] parent, int x, int y) {
		int root_x = find(parent, x);
		int root_y = find(parent, y);

		if (root_x != root_y) {
			parent[root_y] = root_x;
		}
	}

	private static int find(int[] parent, int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent, parent[x]);
	}
}