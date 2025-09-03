import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		// 로직
		// 상근이가 가지고 있는 카드의 수
		int N = Integer.parseInt(br.readLine());
		// 카드의 숫자를 키로 잡고 값을 추가하는 방식으로 Map사용해보자!
		Map<Integer, Integer> cards = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 카드의 숫자
			int num = Integer.parseInt(st.nextToken());
			// 카드숫자가 처음이면!
			if(!cards.containsKey(num)) {
				cards.put(num, 1);
			} 
			// 카드숫자가 이미 있다면!
			else {
				cards.replace(num, cards.get(num) + 1);
			}
		}
		
		// 상근이가 몇개인지 찾을 카드의 숫자 M개
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		// StringBuilder에 카드 숫자에 맞는 값을 넣어주고! 만약 카드 숫자가 key에 없다면
		// 0 넣기
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(!cards.containsKey(x)) {
				sb.append(0).append(" ");				
			} else {
				sb.append(cards.get(x)).append(" ");				
			}
		}
		
		// 출력
		System.out.println(sb);
	}
}