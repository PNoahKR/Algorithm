import java.io.*;
import java.util.*;

class Marble {
    int rx, ry, bx, by, depth;

    public Marble(int rx, int ry, int bx, int by, int depth) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
    }
}

public class Main {
    
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    private static int bfs(int rx, int ry, int bx, int by) {
        Queue<Marble> queue = new LinkedList<>();
        queue.offer(new Marble(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Marble current = queue.poll();

            // 10번 초과해서 움직이면 실패
            if (current.depth >= 10) {
                return -1;
            }

            // 4방향으로 보드 기울이기
            for (int i = 0; i < 4; i++) {
                // 빨간 구슬 굴리기
                int nextRx = current.rx;
                int nextRy = current.ry;
                int redDist = 0; // 이동 거리
                
                // 벽이 아니고, 구멍이 아닐 때까지 직진
                while (board[nextRx + dx[i]][nextRy + dy[i]] != '#' && board[nextRx][nextRy] != 'O') {
                    nextRx += dx[i];
                    nextRy += dy[i];
                    redDist++;
                }

                // 파란 구슬 굴리기
                int nextBx = current.bx;
                int nextBy = current.by;
                int blueDist = 0;
                
                while (board[nextBx + dx[i]][nextBy + dy[i]] != '#' && board[nextBx][nextBy] != 'O') {
                    nextBx += dx[i];
                    nextBy += dy[i];
                    blueDist++;
                }

                // 파란 구슬이 구멍에 빠졌다면 실패
                if (board[nextBx][nextBy] == 'O') {
                    continue;
                }

                // 빨간 구슬만 구멍에 빠졌다면 성공
                if (board[nextRx][nextRy] == 'O') {
                    return current.depth + 1;
                }

                // 둘 다 구멍에 빠지지 않았는데 위치가 같다면 위치 조정
                if (nextRx == nextBx && nextRy == nextBy) {
                    // 더 많이 이동한 구슬이 더 뒤에 있었으므로 한 칸 뒤로 물러남
                    if (redDist > blueDist) {
                        nextRx -= dx[i];
                        nextRy -= dy[i];
                    } else {
                        nextBx -= dx[i];
                        nextBy -= dy[i];
                    }
                }

                // 처음 보는 상태라면 큐에 삽입
                if (!visited[nextRx][nextRy][nextBx][nextBy]) {
                    visited[nextRx][nextRy][nextBx][nextBy] = true;
                    queue.offer(new Marble(nextRx, nextRy, nextBx, nextBy, current.depth + 1));
                }
            }
        }
        
        // 큐가 빌 때까지 성공하지 못하면 탈출 불가
        return -1;
    }
}