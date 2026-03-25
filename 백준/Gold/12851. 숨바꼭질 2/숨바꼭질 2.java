import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        // 방문 여부 및 최단 시간을 저장할 배열
        int[] time = new int[100001];
        int minTime = Integer.MAX_VALUE;
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < time[now]) continue;

            int[] nextPositions = {now - 1, now + 1, now * 2};
            
            for (int next : nextPositions) {
                // 범위를 벗어나면 무시
                if (next < 0 || next > 100000) continue;

                // 찾은 경우
                if (next == K) {
                    minTime = time[now];
                    count++;
                } 
                // 못 찾았고 다음 칸을 갈 수 있는 경우
                else if (time[next] == 0 || time[next] == time[now] + 1) {
                    time[next] = time[now] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(minTime);
        System.out.println(count);
    }
}