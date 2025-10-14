import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// n과 m 받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 집합 만들기
		parent = new int[n + 1];

		// 자기 자신을 부모로 삼는 집합 만들기
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			switch (cmd) {
			case 0:
				union(a, b);
				break;
			case 1:
				if (find(a) == find(b))
					sb.append("YES").append("\n");
				else
					sb.append("NO").append("\n");
					
				break;
			default:
				break;
			}
		}
		
		System.out.println(sb);
	}

	private static int find(int x) {
		if(x == parent[x]) return x;
		return find(parent[x]);

	}

	private static void union(int a, int b) {
		parent[find(b)] = find(a);
	}
}
