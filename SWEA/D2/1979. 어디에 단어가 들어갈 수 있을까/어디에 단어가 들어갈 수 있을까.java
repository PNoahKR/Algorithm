
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			// 입력
            // 단어 퍼즐 크기
            int N = sc.nextInt();
            // 단어의 길이
            int K = sc.nextInt();

            int[][] puzzle = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            // 로직
            // 전체 퍼즐판을 가로로 세로로 돌면서 단어가 들어갈 수 있는 '1'을 만나게 되면 count++ 한다
            // '0' 을 만나게 되면 count = 0으로 초기화 한다
            // 만약 count == K면 result++ 한다.

            // 결과
            int result = 0;
            // 1의 연속 개수
            int count = 0;

            // 가로
            for (int i = 0; i < N; i++) {
                // 한줄을 다 돌면 무조건 초기화
                count = 0;
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] == 1) {
                        count++;
                    } // 0을 만나게 된 경우
                    else {
                        // count된 칸의 길이가 K와 같으면 result++
                        if (count == K) {
                            result++;
                        }
                        // 위 조건과는 관계없이 무조건 0으로 초기화는 해줘야함!
                        count = 0;
                    }
                }
                // 마지막이 1인 경우 확인할 수 있도록~
                if (count == K) {
                    result++;
                }
            }

            // 세로
            for (int j = 0; j < N; j++) {
                count = 0;
                for (int i = 0; i < N; i++) {
                    if (puzzle[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            result++;
                        }
                        count = 0;
                    }
                }
                if (count == K) {
                    result++;
                }
            }


            // 출력
            System.out.println("#" + test_case + " " + result);
		}
	}
}