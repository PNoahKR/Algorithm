import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		// 괄호 짝 연결
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		map.put('>', '<');
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			// 입력
			// 괄호 길이
			int length = sc.nextInt();
			// 괄호 문자열
			String str = sc.next();
			// 여는 괄호 담을 스택
			Stack<Character> stack = new Stack<>();
			// 괄호 로직 성공 여부
			boolean isValid = true;

			// 로직
			// 문자열 순회
			for (int i = 0; i < str.length(); i++) {
				// 괄호 문자
				char c = str.charAt(i);
				// 여는 괄호인 경우 stack에 push
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.push(c);
				}
				// 닫는 괄호인 경우 일단 stack이 비었는지 확인
				else {
					// stack이 비었으면 검증 실패, 반복문 탈출
					if (stack.isEmpty()) {
						isValid = false;
						break;
					}
					// stack이 비어있지 않다면 pop() 후 값 저장
					char pop = stack.pop();
					// 꺼낸 괄호와 현재 가지고 있는 괄호가 일치하는지 검증
					if (pop != map.get(c)) {
						isValid = false;
						break;
					}
				}
			} // for 순회 반복문

			// 출력
			// stack이 비었는지 와 검증에 오류가 없는지 동시에 확인 후 결과 출력
			if (stack.isEmpty() && isValid) {
				System.out.println("#" + test_case + " " + 1);
			} else {
				System.out.println("#" + test_case + " " + 0);
			}

		}
	}
}