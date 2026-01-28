import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int h, r, c; // height(z), row(y), col(x)

    public Point(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};
    static int M, N, H;
    static int[][][] tomatoes; // 3차원 배열 사용
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        tomatoes = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomatoes[h][n][m] == 1) {
                        queue.add(new Point(h, n, m));
                    }
                }
            }
        }

        bfs();

        int maxDays = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    maxDays = Math.max(maxDays, tomatoes[h][n][m]);
                }
            }
        }

        System.out.println(maxDays == 0 ? 0 : maxDays - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 6방향 탐색
            for (int i = 0; i < 6; i++) {
                int nh = current.h + dh[i];
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                // 범위 체크
                if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (tomatoes[nh][nr][nc] == 0) {
                        tomatoes[nh][nr][nc] = tomatoes[current.h][current.r][current.c] + 1;
                        queue.add(new Point(nh, nr, nc));
                    }
                }
            }
        }
    }
}