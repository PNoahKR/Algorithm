import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int R, C, result;
    static char[][] board;
    // 알파벳 고작해봐야 26개임
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 보드 크기 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        // 보드 알파벳 입력받기
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        result = 0;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int r, int c, int sum) {
        // 현재 위치 알파벳 방문
        visited[board[r][c] - 'A'] = true;

        // 방문 최댓값 갱신
        result = Math.max(result, sum);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                // 다음 위치 알파벳 방문안했으면 들어가!
                if(!visited[board[nr][nc] - 'A']) {
                    dfs(nr, nc, sum + 1);
                }
            }
        }

        // 현재 위치에서 탐색이 모두 끝났으니 다음 탐색을 위한 방문해제
        visited[board[r][c] - 'A'] = false;
    }
}