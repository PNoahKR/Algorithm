import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
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
			char[] arr = sc.next().toCharArray();

			// 로직
			// 우선순위를 담을 Map
			Map<Character, Integer> map = new HashMap<>();
			map.put('(', 0);
			map.put('*', 2);
			map.put('+', 1);
			// 문자열을 담을 스택
			ArrayDeque<Character> stack1 = new ArrayDeque<>();
			// 계산을 위한 스택
			ArrayDeque<Integer> stack2 = new ArrayDeque<>();
			
			// 후위 표현식을 담을 StringBuilder
			StringBuilder sb = new StringBuilder();
			// 중위 -> 후위
			// 1. 피연산자는 바로 바로 출력
			// 2. 연산자의 경우
			// 2-1. '(' 일 경우 무조건 push
			// 2-2. + or *의 경우 top 보다 우선순위가 높으면 push, 아니면 pop
			// 2-3. ')' 면 '('를 만날 때 까지 pop
			// 3. 마지막에 남은 스택 털어내기
			for (char ch : arr) {
				if (Character.isDigit(ch)) { // 1. 피연산자
					sb.append(ch);
				} // 2. 연산자
				else {
					// '('은 무조건 넣기
					if (ch == '(') {
						stack1.push(ch);
					} // ')' 일 경우 '('만날때 까지 pop pop pop!
					else if (ch == ')') {
						while (stack1.peek() != '(') {
							sb.append(stack1.pop());
						}
						stack1.pop();
					} // 이제 + or * 뿐임...
					else if (!stack1.isEmpty() && map.get(ch) > map.get(stack1.peek())) {
						stack1.push(ch);
					} else {
						while (!stack1.isEmpty() && map.get(ch) <= map.get(stack1.peek())) {
							sb.append(stack1.pop());
						}
						stack1.push(ch);
					}
				}
			}
			
			// 후위 표현식 계산
			for(char ch : sb.toString().toCharArray()){
				// 피연산자면 넣기
				if (Character.isDigit(ch)) {
					stack2.push(ch - '0');
				} // 연산자 일 때 계산하기
				else if(ch == '+') {
					int b = stack2.pop();
					int a = stack2.pop();
					stack2.push(a + b);
				}
				else if(ch == '*') {
					int b = stack2.pop();
					int a = stack2.pop();
					stack2.push(a * b);
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + stack2.pop());
		}
	}
}