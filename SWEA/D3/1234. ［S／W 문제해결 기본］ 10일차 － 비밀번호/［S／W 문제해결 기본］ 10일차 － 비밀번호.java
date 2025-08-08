import java.util.ArrayDeque;
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
			int n = sc.nextInt();
			String password = sc.next();

			// 로직
			// 문자를 담을 스택 생성
			ArrayDeque<Character> stack = new ArrayDeque<>();

			// 문자열을 순회 하며 스택에 넣... 기전에 스택이 비어있느지 확인
			// 비어있다면 스택에 문자를 넣고
			// 아니라면 넣을 문자와 스택의 top 데이터를 비교해 같으면 pop하고 아니면 입력 문자를 push 한다

			for (int i = password.length() - 1; i >= 0; i--) {
				char ch = password.charAt(i);
				if (stack.isEmpty() || stack.peek() != ch) {
					stack.push(ch);
				} else {
					stack.pop();
				}
			}

			// 출력
			System.out.print("#" + test_case + " ");
			for(char ch : stack) {
				System.out.print(ch);
			}
			System.out.println();
        }
	}
}