
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
			int N = sc.nextInt();
			String str = sc.next();
			
			// 로직
			// 최대 연속 횟수
			int max = 0;
			
			// 순회 로직 내에서 연속되는 1을 저장할 변수
			int sum = 0;
			
			// 문자열을 순회하면서 '1'을 발견하면 sum++ 
			// '0'을 만나면 max와sum을 비교해 치환하고 sum을 다시 0으로 초기화
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '1') {
					sum++;
				} else {
					max = Math.max(max, sum);
					sum = 0;
				}
			}
			// 마지막 수가 '1'인 경우 max와 sum을 비교하지 않음으로 한	번 더 비교
			max = Math.max(max, sum);
			
			// 출력
			System.out.println("#" + test_case + " " + max);
		}
	}
}