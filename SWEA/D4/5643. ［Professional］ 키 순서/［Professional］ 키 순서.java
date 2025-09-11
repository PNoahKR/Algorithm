import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			// 인원수 N
			int N = Integer.parseInt(br.readLine());
			int[][] dist = new int[N + 1][N + 1];
			// 간선(키 비교) 수 M
			int M = Integer.parseInt(br.readLine());

			// 배열 초기화 작업
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					dist[i][j] = INF;
				}
			}

			// 키 비교 관계 만들기
			StringTokenizer st;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a][b] = 1;
			}

			// 로직
			// 나보다 큰사람 + 작은사람 = N-1 즉, 자기 자신을 제외하고 자신과 관계된 사람을 알아야하니까
			// 플로이드 워셜을 통해서 모든 정점의 경로를 파악하고
			// 한 정점에 row, col에 INF > ? > 0 인 값들의 개수가 N-1인 번호만 자기 순서를 안다

			for (int k = 1; k <= N; k++) {
				for (int from = 1; from <= N; from++) {
					if (dist[from][k] == INF)
						continue;
					for (int to = 1; to <= N; to++) {
						if (dist[k][to] == INF)
							continue;
						dist[from][to] = Math.min(dist[from][to], dist[from][k] + dist[k][to]);
					}
				}
			}

			// 자신과 다른 학생들 간의 상위 하위 관계가 얼마나 연결되있는지 확인하는 배열
			int[] student = new int[N + 1];
			// 결과를 담을 변수
			int result = 0;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// INF -> 관계가 연결되어잇지 않음
					// 0 -> 자기 자신
					if (dist[i][j] < INF && dist[i][j] > 0) {
						// 이렇게 한 이유는 2차원 배열에서 결국 i, j가 row, col값이고
						// 각각 번호별로 키 관계를 알수 있으면 배열에 추가해야하기 때문에
						// I, J 각각 +1씩 해주면 중첩반복문을 하나로 써도 된다.
						student[i]++;
						student[j]++;
						// student배열에서 값이 N-1이 된다면 모든 경로와 연결됐다는 뜻임으로
						// 자신의 키를 알 수 있다.
						if (student[i] == N - 1)
							result++;
						if (student[j] == N - 1)
							result++;
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + result);

		}
	}
}
