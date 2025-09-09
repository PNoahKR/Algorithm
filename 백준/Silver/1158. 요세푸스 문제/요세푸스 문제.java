import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 수가 회전할 큐
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }
        // 출력값에 맞춰 형식 꾸리기
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        // idx값을 매 순회마다 올릴거야
        // K의 배수가 아니면 큐의 맨 앞 값을 뒤로 보내
        // 그리고 K의 배수가 될때 마다 큐에서 값을 빼내 sb에 넣고
        // 이 과정을 반복하다 보면 결국 1개의 수가 남게 되고
        // 그때는 마지막에 ">"를 넣어주면 돼
        int idx = 1;
        while (!q.isEmpty()) {
            // 큐에 1개만 남으면!
            if(q.size() == 1) {
                sb.append(q.poll()).append(">");
            } 
            // K의 배수일 땐 빼서 sb에 추가
            else if(idx % K == 0) {
                sb.append(q.poll()).append(", ");
            } 
            // K의 배수가 아니면 빼서 뒤에 넣어
            else {
                int temp = q.poll();
                q.offer(temp);
            }
            // idx의 값은 계속 올려
            idx++;
        }
        // 출력
        System.out.println(sb);
    }
}
