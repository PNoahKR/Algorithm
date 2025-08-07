
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
			// 초원 입력
			String str = sc.next();
			
			// 로직
			// 초원에 잡초가 자라고 가려진 공의 최소 개수를 구하는 것
			// '('이 있을 경우 다음 잡초여부와 상관없이 공의 개수 + 1
			// ')'이 있을 경우 앞에 '('이 있을 경우 이미 개수 카운트가 됐으니 넘김
			//				앞에 '|'이 있을 경우 공이 있다는 가정이 생김, 공의 개수 + 1
			
			// 공의 개수
			int ball = 0;
			
			
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '(') {
					ball++;
				} else if (str.charAt(i) == ')' && str.charAt(i-1) == '|') {
					ball++;
				}
			}
			
			
			// 출력
			System.out.println("#" + test_case + " " + ball);
		}
	}
}