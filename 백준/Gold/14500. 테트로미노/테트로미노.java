import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int maxScore = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // DFS로 ㅗ제외 탐색
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                // ㅗ 모양 별도 처리
                checkTShape(i, j);
            }
        }

        System.out.println(maxScore);
    }

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            maxScore = Math.max(maxScore, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + map[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    // ㅗ 모양 처리
    static void checkTShape(int x, int y) {
        int sum = map[x][y]; // 센터 값
        int wingCount = 0;
        int minWing = Integer.MAX_VALUE;

        // 4방향 날개 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 내에 있다면 날개로 추가
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                wingCount++;
                sum += map[nx][ny];
                minWing = Math.min(minWing, map[nx][ny]);
            }
        }

        // 날개가 4개면(십자가 모양) -> 가장 작은 날개 하나를 뺌 (= ㅗ, ㅜ, ㅓ, ㅏ 중 최대)
        if (wingCount == 4) {
            maxScore = Math.max(maxScore, sum - minWing);
        }
        // 날개가 3개면(이미 T자 모양) -> 그대로 비교
        else if (wingCount == 3) {
            maxScore = Math.max(maxScore, sum);
        }
        // 날개가 2개 이하면 T자를 만들 수 없음 (무시)
    }
}