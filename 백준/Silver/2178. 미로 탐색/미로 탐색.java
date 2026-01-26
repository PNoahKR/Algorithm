import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0 ,0};
    static int[] dc = {0 ,0 ,-1, 1};

    static int N, M, result;
    static int[][] map;
    static boolean[][] flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        flag = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        flag[r][c] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dr[i];
                int ny = cy + dc[i];

                // 1. 맵 범위를 벗어나는지 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 2. 방문한 적이 없고(visited false), 길이 있는 곳(1)인지 체크
                // 이미 방문했다면 거기가 더 짧거나 같은 경로임
                if (flag[nx][ny] || map[nx][ny] == 0) continue;

                // 이동 가능하면 큐에 넣고 거리 갱신
                queue.add(new int[] {nx, ny});

                // **핵심 로직**: 이전 칸의 거리 + 1을 현재 칸에 저장
                map[nx][ny] = map[cx][cy] + 1;
                flag[nx][ny] = true;
            }
        }
    }
}
