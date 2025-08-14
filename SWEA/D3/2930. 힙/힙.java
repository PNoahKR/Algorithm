import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
	
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		// 입력
			// 연산해야 되는 연산 수
			int N = sc.nextInt();

			// 로직
			// 연산을 수행할 PriorityQueue 생성 (최대힙)

			// Colletions.reverseOrder() 사용
//			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			// Comparator 사용
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}

			});

			// 2번 연산에 의해 출력되는 값을 담을 StringBuilder
			StringBuilder sb = new StringBuilder();

			// N번의 연산 수행
			for (int i = 0; i < N; i++) {
				int C = sc.nextInt();
				// 만약 1을 입력 받는다면 x를 추가로 더 입력 받는다.
				if (C == 1) {
					int x = sc.nextInt();
					pq.offer(x);
				} else {
					if (pq.isEmpty()) {
						sb.append(-1).append(" ");
					} else {
						sb.append(pq.poll()).append(" ");
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + sb);
		}
	}
}