import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K ){
            System.out.println(0);
        }
        else {
            bfs(N, K);
        }
    }

    private static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        visited[start] = 1;

        while (!q.isEmpty()){
            int cur = q.poll();

            int[] nextMov = {cur - 1, cur + 1, cur * 2};

            for (int next : nextMov) {
                if (next == target) {
                    System.out.println(visited[cur]);
                    return;
                }
                if(next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}
