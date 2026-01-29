import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int M, N;
    static int[][] tomatoes;
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        bfs();

        int maxDays = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDays = Math.max(maxDays, tomatoes[i][j]);
            }
        }

        System.out.println(maxDays == 0 ? 0 : maxDays - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (tomatoes[nr][nc] == 0) {
                        tomatoes[nr][nc] = tomatoes[current.r][current.c] + 1;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }
    }
}