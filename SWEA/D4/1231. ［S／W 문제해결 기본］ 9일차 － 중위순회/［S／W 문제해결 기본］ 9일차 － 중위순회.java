import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static StringBuilder sb;
    
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 입력
			// 정점의 총 수 N
			int N = Integer.parseInt(sc.nextLine());

			// 자식 노드 배열 생성
			int[] left = new int[N + 1];
			int[] right = new int[N + 1];

			// 부모 노드 배열 생성
			int[] parent = new int[N + 1];

			// 데이터를 집어 넣은 배열
			String[] data = new String[N + 1];

			for (int i = 0; i < N; i++) {
				// 입력 케이스에 따른 입력처리를 해줘야 함!
				// (현재정점의번호 노드데이터 왼쪽자식번호 오른쪽자식번호)
				// 문자 줄 한줄 다 받기!
				String line = sc.nextLine();
				// " "을 기준으로 문자열 자르기
				String[] lines = line.split(" ");

				int p = Integer.parseInt(lines[0]);
				String word = lines[1];

				if (lines.length >= 4) {
					int cr = Integer.parseInt(lines[3]);

					right[p] = cr; // 부모 -> 오자
					parent[cr] = p;// 오자 -> 부모
				}
				if (lines.length >= 3) {
					int cl = Integer.parseInt(lines[2]);

					left[p] = cl;
					parent[cl] = p;
				}

				data[p] = word;
			}
			// 로직
			// 1. 루트 노드를 찾아야한다.
			// why? -> 우리가 중위순회를 진행 할 때에 첫번째 시작! -> 루트노드 부터 시작
			// 1 ~ N 까지의 노드 하나를 자아서 부모노드까지 탐색
			int root = N; // 임시 루트노드
			while (parent[root] != 0) {
				root = parent[root];
			}

			// 2. 중위순회 방문 체크! L V R
			// Stringbuilder에 출력값 순차 저장!
			sb = new StringBuilder();
			inOrder(root, left, right, data);

			// 출력
			System.out.println("#" + test_case + " " + sb);
		}
	}
    public static void inOrder(int T, int[] left, int[] right, String[] data) {
		if (T != 0) {
			inOrder(left[T], left, right, data);
			sb.append(data[T]);
			inOrder(right[T], left, right, data);
		}
	}
}