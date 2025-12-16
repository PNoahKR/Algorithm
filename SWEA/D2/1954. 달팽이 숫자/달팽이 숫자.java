import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // 입력
            // N입력 받기
            int N = Integer.parseInt(br.readLine());

            // 로직
            // 위쪽 방향, 아래쪽 방향 진행시 -1 칸씩 채워야할 공간이 줄어든다.
            int[][] matrix = new int[N][N];

            int len = N; // 채워야할 길이
            int dir = 0; // 방향 (0: 오른쪽, 1:아래, 2: 왼쪽, 3:위)
            int num = 1; // 숫자

            int r = 0;
            int c = -1;

            while(len > 0) {
                if((dir%4) == 0) {
                    for (int i = 0; i < len; i++) {
                        matrix[r][++c] = num++;
                    }
                } else if ((dir%4) == 1) {
                    len--;
                    for (int i = 0; i < len; i++) {
                        matrix[++r][c] = num++;
                    }

                } else if ((dir%4) == 2) {
                    for (int i = 0; i < len; i++) {
                        matrix[r][--c] = num++;
                    }
                } else if ((dir%4) == 3) {
                    len--;
                    for (int i = 0; i < len; i++) {
                        matrix[--r][c] = num++;
                    }
                }
                dir++;
            }

            // 출력
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } // tc반복문
    }
}
