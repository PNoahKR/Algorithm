
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
			// 문자열 길이
			int N = sc.nextInt();
			// 회문 길이
			int M = sc.nextInt();
			// 문자열 저장할 배열
			char[] str = new char[N];
			str = sc.next().toCharArray();
			
			// 로직
			// 회문이 존재할 경우 시작 인덱스
			int idx = 0;
			// 회문이 있는지 검증하는 boolean값
			boolean isPalindrome = false;
			
			// 왼쪽부터 오른쪽으로 순회
			// 인덱스 0 부터 N - M 까지 탐색 
			for (int i = 0; i < N - M + 1; i++) {
				boolean isOk = true;
				// 회문 검사는 M / 2까지 탐색
				for (int j = 0; j < M / 2; j++) {
					if(str[i] != str[i + M - 1 - j]) {
						isOk = false;
						break;
					} // 증명
				} // 회문 검사
				if(isOk) {
					isPalindrome = true;
					idx = i;
					break;
				}
			} // 전체 순회
			
			// 출력
			if(isPalindrome) {
				System.out.print("#" + test_case + " ");
				for(int i = idx; i < idx + M; i++) {
					System.out.print(str[i]);
				}
				System.out.println();				
			} else {
				System.out.println("#" + test_case + " NONE");
			}
		}
	}
}