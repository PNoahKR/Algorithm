import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        // 수열의 길이
        int N = Integer.parseInt(br.readLine());
        // 수열을 받을 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 로직
        // 정답을 담을 배열을 만들어준다!
        int[] answer = new int[N];
        
        // 대기 인덱스 스택
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 먼저 제일 앞 번호는 비교할 뒷 대상이 없으니 스택에 집어 넣엇!
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
            	answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	answer[stack.pop()] = -1;
        }
        
        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i : answer) {
        	sb.append(i).append(" ");
        }
        
        System.out.println(sb);
	}
}
