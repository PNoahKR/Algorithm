import java.io.*;
import java.util.*;

public class Main {

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        // 맨 위 꼭짓점 좌표는 행(row) 0, 열(col) N - 1
        draw(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void draw(int r, int c, int n) {
        // 높이가 3이 되면 더 이상 쪼개지 않고 기본 삼각형을 그림
        if (n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = '*';
            map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = '*';
            map[r + 2][c - 1] = '*';
            map[r + 2][c] = '*';
            map[r + 2][c + 1] = '*';
            map[r + 2][c + 2] = '*';
            return;
        }

        // 높이가 3보다 크면 절반으로 쪼개서 3개의 삼각형을 호출
        int nextSize = n / 2;
        
        draw(r, c, nextSize);
        
        draw(r + nextSize, c - nextSize, nextSize);
        
        draw(r + nextSize, c + nextSize, nextSize);
    }
}