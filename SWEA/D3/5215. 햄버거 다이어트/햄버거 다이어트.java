
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int score, N, L;
    static boolean[] check;
    
    public static void powerset(int idx, int[][] element) {
        if (idx == N) {
            int flavor = 0;
            int kcal = 0;
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    flavor += element[i][0];
                    kcal += element[i][1];
                }
            }
            if (L >= kcal) {
                score = Math.max(flavor, score);
            }
            return;
        }

        check[idx] = true;
        powerset(idx + 1, element);

        check[idx] = false;
        powerset(idx + 1, element);
    }
    
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            // 입력
            // 재료수
            N = sc.nextInt();
            // 칼로리 제한
            L = sc.nextInt();

            // 재료에 따른 점수와 칼로
            int[][] element = new int[N][2];
            for (int i = 0; i < N; i++) {
                element[i][0] = sc.nextInt();
                element[i][1] = sc.nextInt();
            }
            // 로직
            // 조합을 다 해봐! 칼로리 제한 넘으면 땡!
            check = new boolean[N];
            score = 0;
            powerset(0, element);


            // 출력
            System.out.println("#" + test_case + " " + score);
		}
	}
}