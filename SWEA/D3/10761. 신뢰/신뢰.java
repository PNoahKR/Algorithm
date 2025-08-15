
import java.util.Scanner;
import java.io.FileInputStream;
/*
명령 즉, N개의 버튼을 눌러야 하는 로봇과 버튼은
무조건 순서대로 진행되어야 한다.

오렌지와 블루 각각의 로봇은 각각의 행동을 할 수 있다
=> 두 로봇은 같은 시간대에서 각각 행동할 수 있다.
 */
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
            // 눌러야 하는 버튼의 개수
            int N = sc.nextInt();

            // 각 로봇의 임무 시간
            int OTime = 0;
            int BTime = 0;

            // 각 로봇의 현재 위치
            int O_Idx = 1;
            int B_Idx = 1;

            // 로직
            for (int i = 0; i < N; i++) {
                char robot = sc.next().charAt(0);
                int button = sc.nextInt();
                // 블루의 명령
                if(robot == 'B') {
                    // 버튼 위치까지 이동하는 시간
                    int moveTime = Math.abs(button - B_Idx);
                    // 해당 버튼까지 소모된 시간(이전 행동 시간들도 포함한다)
                    BTime += moveTime;

                    // 만약 오렌지의 임무소모 시간보다 이전이라면 오렌지의 임무수행(버튼누름) 까지 기다려야하니
                    // 오렌지 시간과 블루 시간을 비교해 더 큰쪽으로 블루의 시간을 추가해준다
                    BTime = Math.max(BTime, OTime);

                    // 버튼 누르는 행동 +1
                    BTime++;
                    // 현재위치 갱신
                    B_Idx = button;
                }
                // 오렌지의 명령
                else if (robot == 'O') {
                    // 버튼 위치까지 이동하는 시간
                    int moveTime = Math.abs(button - O_Idx);
                    // 해당 버튼까지 소모된 시간(이전 행동 시간들도 포함한다)
                    OTime += moveTime;

                    // 만약 오렌지의 임무소모 시간보다 이전이라면 오렌지의 임무수행(버튼누름) 까지 기다려야하니
                    // 오렌지 시간과 블루 시간을 비교해 더 큰쪽으로 블루의 시간을 추가해준다
                    OTime = Math.max(BTime, OTime);

                    // 버튼 누르는 행동 +1
                    OTime++;
                    // 현재위치 갱신
                    O_Idx = button;
                }
            }

            // 최종 소모 시간은 두 로봇이 소모한 시간 중 가장 긴 시간!
            int totalTime = Math.max(OTime, BTime);

            // 출력
            System.out.println("#" + test_case + " " + totalTime);

		}
	}
}