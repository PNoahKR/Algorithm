
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
            // 입력 받을 정수의 개수
            int N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            // 로직
            // 2개의 수를 곱한 값의 모든 경우를 뽑아보고, 그중 단조인 수와 max와 비교해서 최댓값을 구하자
            int max = -1; // 단조 증가하는 수가 없다면 -1출력

            // Ai : 전체를 돌면서 곱하게 될거라 결국 마지막 수는 이미 다 곱해본 경우가 되기 때문에 패쓰한다!
            for (int i = 0; i < N-1; i++) {
                // Aj : Ai 다음 부터 마지막 까지!
                for (int j = i+1; j < N; j++) {
                    boolean danjo = true;
                    int multi = arr[i] * arr[j];
                    // 먼저 곱해서 나온 값이 max보다 큰값인지 확인해보자 아니라면 굳이 단조하는 수인걸 알 필요 없다
                    if(multi > max) {
                        char[] chars = String.valueOf(multi).toCharArray();
                        for (int k = 0; k < chars.length - 1; k++) {
                            if (chars[k] > chars[k+1]) {
                                danjo = false;
                                break;
                            }
                        }
                        if(danjo) {
                            max = multi;
                        }
                    } // multi > max 조건문
                } // Aj 반복문
            } // Ai 반복문

            // 출력
            System.out.println("#" + test_case + " " + max);
		}
	}
}