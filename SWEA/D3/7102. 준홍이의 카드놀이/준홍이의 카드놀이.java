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
			// 첫번째 카드 세트의 개수
			int N = sc.nextInt();
			// 두번째 카드 세트의 개수
			int M = sc.nextInt();
			
			Queue<Integer> deck1 = new LinkedList<>();
			Queue<Integer> deck2 = new LinkedList<>();
			
			// 두 카드 세트에 숫자카드 집어 넣기
			for (int i = 1; i <= N; i++) {
				deck1.offer(i);
			}
			for (int i = 1; i <= M; i++) {
				deck2.offer(i);
			}
			
			// 로직
			// 두 카드의 합 중 가장 높은 값은 N + M일 것이다.
			// 인덱스가 N+M까지 있는 배열을 만들어 두 덱의 카트를 한장씩 뽑아서 나올 수 있는 수를
			// 배열 인덱스에 수가 나올 때마다 해당 수 배열에 +1씩 카운트 해서 가장 높은 수를 가진 배열을 출력하고자 한다.
			int[] arr = new int[N+M+1];
			
			// 나온 수 중 가장 많은 횟수
			int max = 0;
			
			// 두 카드를 골고루 하나씩 비교해서 뽑아 합할 이중반복문
			for (int i = 0; i < N; i++) {
				// 첫번째 덱을 기준으로 순회됨으로 다시 집어 넣을 필요 X
				int one = deck1.poll();
				for (int j = 0; j < M; j++) {
					// 두번째 덱은 첫번째 덱을 기준으로 계속해서 덱의 모든 카드 숫자를 더해야함
					// poll()로 뽑아서 값을 더해보고 다음 반복문을 위해 offer()로 뒤로 집어넣기
					int two = deck2.poll();
					arr[one + two]++;
					max = Math.max(max, arr[one + two]);
					deck2.offer(two);
				}
			}
			
			
			// 출력
			StringBuilder sb = new StringBuilder();
			// 등장확률이 같은 수가 있을 수 있으니 StringBuilder에 max만큼의 등장횟수를 가진 수를 가져와 출력
			for(int i = 1; i < arr.length; i++) {
				if(arr[i] == max) {
					sb.append(i).append(" ");
				}
			}
			System.out.println("#" + test_case + " " + sb);
		}
	}
}