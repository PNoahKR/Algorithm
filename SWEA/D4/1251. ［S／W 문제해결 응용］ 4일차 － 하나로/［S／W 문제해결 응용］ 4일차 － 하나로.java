import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static class Edge implements Comparable<Edge> {
		int to;
		double dist;

		public Edge(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 섬의 개수
			int N = Integer.parseInt(br.readLine());

			// 간선리스트 생성
			List<Edge>[] edges = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				edges[i] = new ArrayList<>();
			}


			// 섬의 X좌표 / Y좌표 받을 배열
			int[] xPosition = new int[N];
			int[] yPosition = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			// x 좌표 받기
			for (int i = 0; i < N; i++) {
				xPosition[i] = Integer.parseInt(st.nextToken());
			}
			// y 좌표 받기
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yPosition[i] = Integer.parseInt(st.nextToken());
			}

			// 로직
			// 간선 만들기
			// 모든 섬을 이어 간선을 만든다.
			// 대각선 길이를 구하는 것을 어떻게 할 까 고민했는데
			// L^2를 준 이유가 결국 대각선의 길이를 구하는 것을 쉽게 하기 위해서였다.
			// 직선과 대각선의 길이를 유클리드 거리를 활용해 (x1 - x2)^2 + (y1 - y2)^2 으로 해서
			// 원래 길이의 ^2 를 바로 구했다.
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					long p = xPosition[i] - xPosition[j];
					long q = yPosition[i] - yPosition[j];
					double distance = (double)(p * p + q * q);
					edges[i].add(new Edge(j, distance));
					edges[j].add(new Edge(i, distance));
				}
			}
			
			double totalDistance = 0;
			
			// PriorityQueue / boolean 배열 생성
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N];
			
			pq.offer(new Edge(0, 0));
			
			while(!pq.isEmpty()) {
				Edge curEdge = pq.poll();
				
				int next = curEdge.to;
				double dist = curEdge.dist;
				
				if(visited[next]) continue;
				
				visited[next] = true;
				totalDistance += dist;
				
				for (Edge e : edges[next]) {
					int nnext = e.to;
					double ndist = e.dist;
					if(!visited[nnext]) {
						pq.offer(new Edge(nnext, ndist));
					}
				}
			}
			
			// 세율
			double E = Double.parseDouble(br.readLine());
			totalDistance *= E;

			// 출력
			System.out.println("#" + test_case + " " + Math.round(totalDistance));
		}
	}

	private static void union(int[] p, int x, int y) {
		int root_x = findSet(p, x);
		int root_y = findSet(p, y);
		p[root_y] = root_x;
	}

	private static int findSet(int[] p, int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p, p[x]);
	}
}
