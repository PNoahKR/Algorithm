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
			// char 배열로 메모리를 받아보자
			char[] memory = sc.next().toCharArray();
			
			// 로직
			// 메모리의 초기 bit는 모두 0 이고, 원래 메모리에서 0에서 1 또는 1에서 0 으로 바뀔 때 마다
			// 수정을 진행함으로 값이 바뀌는 구간 마다 수정 횟수를 추가해주면 된다.
			// 수정 횟수
			int count = 0;
			
			
			// 현재(초기) 문자
			char current = '0';
			for (int i = 0; i < memory.length; i++) {
				if(memory[i] != current) {
					count++;
					// 현재 문자를 바꿔준다!
					current = memory[i];
				}
			}
			
			// 출력
			System.out.println("#" + test_case + " " + count);
		}
	}
}