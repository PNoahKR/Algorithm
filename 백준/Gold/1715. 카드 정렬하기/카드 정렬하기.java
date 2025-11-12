import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		int totalCount = 0;
		
		while(q.size() > 1) {
			int deck1 = q.poll();
			int deck2 = q.poll();
			
			int sum = deck1 + deck2;
			
			totalCount += sum;
			
			q.add(sum);
		}
		
		System.out.println(totalCount);
	}
}
