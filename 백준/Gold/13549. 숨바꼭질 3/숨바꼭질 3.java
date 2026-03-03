import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(K <= N) {
            System.out.println(N - K);
            return;
        }

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int target) {
        Deque<Integer> deque = new LinkedList<>();
        int[] time = new int[MAX + 1];

        Arrays.fill(time, -1);

        deque.addFirst(start);
        time[start] = 0; // 시작점은 0초

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            
            // 종료 조건
            if (current == target) {
                return time[current];
            }
            
            // 순간이동 (0초): 최우선이므로 addFirst
            int teleport = current * 2;
            if (teleport <= MAX && time[teleport] == -1) {
                time[teleport] = time[current]; // 시간 추가 안 함 (0초)
                deque.addFirst(teleport);
            }
            
            // 뒤로 걷기 (1초): addLast
            int walkBack = current - 1;
            if (walkBack >= 0 && time[walkBack] == -1) {
                time[walkBack] = time[current] + 1; // 1초 추가
                deque.addLast(walkBack);
            }
            
            // 앞으로 걷기 (1초): addLast
            int walkForward = current + 1;
            if (walkForward <= MAX && time[walkForward] == -1) {
                time[walkForward] = time[current] + 1; // 1초 추가
                deque.addLast(walkForward);
            }
        }
        return 0;
    }
}