import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 인원의 수
        int N = Integer.parseInt(br.readLine());
        // 대기 공간
        Deque<Integer> stack = new ArrayDeque<>();
        // 순서
        int num = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int X = Integer.parseInt(st.nextToken());

            if(X != num) {
                stack.push(X);
            } else {
                num++;
            }

            while(!stack.isEmpty()) {
                if(stack.peek() == num) {
                    stack.pop();
                    num++;
                } else {
                    break;
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
