
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 입력
			int T = sc.nextInt();
			char[][] arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int palindrome = 100;

			while (palindrome > 0) {
				boolean found = false;
				// 수평 찾기
				// row 행은 고정
				for (int i = 0; i < 100; i++) {
					// column 열은 (열의 길이)8 - (회문길이)n + 1 만큼 탐색
					for (int j = 0; j < 100 - palindrome + 1; j++) {
						// 회문 조건
						boolean isOk = true;
						// 회문을 찾기 위해 n/2만큼 순회
						for (int k = 0; k < palindrome / 2; k++) {
							// column 값에 j + k 와 j + n - 1 - k 비교
							// j <-> j+n-1 은 n길이 만큼의 비교점
							if (arr[i][j + k] != arr[i][j + palindrome - 1 - k]) {
								isOk = false;
								break;
							}
						}
						if (isOk) {
							found = true;
						}
					}
				} // 고정된 row 반복문
				if(found) {
					break;
				}

				// 수직 찾기 (수평과 같은 맥락)
				for (int j = 0; j < 100; j++) {
					for (int i = 0; i < 100 - palindrome + 1; i++) {
						boolean flag = true;
						for (int k = 0; k < palindrome / 2; k++) {
							if (arr[i + k][j] != arr[i + palindrome - 1 - k][j]) {
								flag = false;
								break;
							}
						}
						if (flag) {
							found = true;
						}
					}
				} // 고정된 column 반복문
				if(found) {
					break;
				}
				
				palindrome--;
			}

			// 출력
			System.out.println("#" + T + " " + palindrome);
		}
	}
}