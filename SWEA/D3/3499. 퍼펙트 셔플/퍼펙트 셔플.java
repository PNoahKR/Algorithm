import java.util.LinkedList;
import java.util.Queue;
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
			// 카드 개수 입력
			int N = sc.nextInt();

			// 카드를 담을 큐 생성
			Queue<String> cards = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				cards.offer(sc.next());
			}

			// 로직
			// 첫번째 카드뭉치와 두번째 카드뭉치 큐 생성
			Queue<String> deck1 = new LinkedList<>();
			Queue<String> deck2 = new LinkedList<>();

			// 홀수 일 경우 먼저 놓는 첫번째 카드뭉치에서 1장 더 많이 들어가게 됨으로,
			// (N + 1) / 2 까지 카드 뭉치를 받는다. -> 짝수일 때에 N/2와 (N+1)/2는 같음
			for (int i = 0; i < (N + 1) / 2; i++) {
				deck1.offer(cards.poll());
			}

			// 두번째 카드 뭉치는 남은 카드를 집어 넣는다
			while (!cards.isEmpty()) {
				deck2.offer(cards.poll());
			}

			// 카드를 합칠 때 인덱스 값 나누기 2의 나머지가 0일때 deck1, 아닐때 deck2에서 뽑아서 넣어 카드를 섞는다.
			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					cards.offer(deck1.poll());
				} else {
					cards.offer(deck2.poll());
				}
			}

			// 출력
			System.out.print("#" + test_case + " ");
			for (String s : cards) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}