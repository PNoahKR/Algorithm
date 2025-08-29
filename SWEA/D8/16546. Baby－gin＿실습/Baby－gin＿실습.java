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
			String cards = sc.next();
			
			
			// 로직
			boolean isBabygin = false;
			int run = 0;
			int tripple = 0;
			int[] counts = new int[10];
			for (int i = 0; i < cards.length(); i++) {
				counts[cards.charAt(i) - '0']++;
			}
			
			for(int i = 0; i < 10; i++) {
				if(counts[i] >= 3) {
					tripple += counts[i] / 3;
					counts[i] = counts[i] % 3;
				}
			}
			
			for (int i = 0; i < 8; i++) {
				if(counts[i] > 0 && counts[i+1] > 0 && counts[i+2] > 0) {
					int mn = Math.min(counts[i], Math.min(counts[i+1], counts[i+2]));
					run += mn;
					counts[i] -= mn;
					counts[i+1] -= mn;
					counts[i+2] -= mn;
				}
			}
			
			// 출력
			if(run + tripple >= 2) {
				isBabygin = true;
			}
			
			System.out.println("#" + test_case + " " + isBabygin);

		}
	}
}