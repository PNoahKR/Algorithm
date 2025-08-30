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
            // 6장의 카드를 입력받기
            // 전~에 카드의 수를 카운트 하기 위한 배열 생성
            int[] count = new int[10];

            // 카드 숫자 받기
            String cards = sc.next();
            // 6장의 임의의 카드라는 제약 조건이 있음
            for (int i = 0; i < 6; i++) {
                count[cards.charAt(i) - '0']++;
            }

            // 로직
            // 0~9 까지 run과 triplet을 검사!
            // run 과 triplet의 합이 2 이상이 되면 baby-gin
            int run = 0;
            int triplet = 0;

            // run 확인!
            // edge 케이스 (123123)일 경우 1에서 카운트를 1만 올린다면 정답이 아니게 된다.
            for (int i = 0; i < 8; i++) {
                if (count[i] > 0 && count[i+1] > 0 && count[i+2] > 0) {
                    int min = Math.min(count[i], Math.min(count[i+1], count[i+2]));
                    triplet = triplet + min;
                    count[i] -= min;
                    count[i+1] -= min;
                    count[i+2] -= min;
                }
            }

            // triplet 확인!
            // edge 케이스 (666666)일 경우, 6에서 3만 빼고 다음 숫자로 넘어가게되면 1만 올라간꼴
            for (int i = 0; i < 10; i++) {
                if (count[i] >= 3) {
                    if (count[i] == 6) {
                        triplet = triplet + 2;
                        count[i] = 0;
                        continue;
                    }
                    triplet++;
                    count[i] -= 3;
                }
            }

            // 출력
            if (triplet+run == 2) {
                System.out.println("#" + test_case + " " + true);
            } else {
                System.out.println("#" + test_case + " " + false);
            }
        }
	}
}