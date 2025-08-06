import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    // 상하좌우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    // 좌상 우상 우하 좌하
    static int[] drx = { -1, -1, 1, 1 };
    static int[] dcx = { -1, 1, 1, -1 };
     
    static int[][] arr;
    static int N, M;
 
    private static int sprayBugs(int i, int j, int[] dr, int[] dc) {
        int bugSum = arr[i][j];
        for (int k = 0; k < 4; k++) {
            for (int m = 1; m < M; m++) {
                int nr = i + dr[k] * m;
                int nc = j + dc[k] * m;
                if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    bugSum += arr[nr][nc];
                }
            }
        }
        return bugSum;
    }
     
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 입력
            N = sc.nextInt();
            M = sc.nextInt();
            // 파리영역
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
 
            // 로직
            // 처치한 파리의 최대 수
            int kill = 0;
            // 배열의 전체를 돌면서 M 세기의 스프레이로 처치한 파리의 최대 값을 구해야 한다.
            // 뿌려지는 영역 일부가 벗어나도 되기 때문에 탐색의 범위는 전체이다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    kill = Math.max(kill, sprayBugs(i, j, dr, dc));
                    kill = Math.max(kill, sprayBugs(i, j, drx, dcx));
                }
            }
 
            // 출력
             
            System.out.println("#" + test_case + " " + kill);
         
             
        }
    }
}