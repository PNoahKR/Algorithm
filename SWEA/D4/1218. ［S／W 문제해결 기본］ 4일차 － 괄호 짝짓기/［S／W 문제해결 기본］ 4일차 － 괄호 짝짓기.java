import java.util.*;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            // 입력
            // 괄호의 길이 입력 받기
            int N = sc.nextInt();
            // 괄호 String 받기
            String str = sc.next();

            // 로직
            // 스택을 사용해 여는 괄호는 스택에 집어넣고, 닫는 괄호를 만나면 스택을 확인해 빼내는 작업을 한다.
            // 괄호의 종류가 4개라 코드의 가독성을 위해 Map을 사용해볼까 한다.
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            map.put('>', '<');

            // 괄호를 담기 위한 stack
            Deque<Character> stack = new ArrayDeque<>();

            // 괄호 유효성을 확인하기 위한 for문 과 boolean
            boolean isOK = true;
            for (int i = 0; i < N; i++) {
                char ch = str.charAt(i);
                // key가 아닌 괄호 즉, 여는 괄호면!
                if (!map.containsKey(ch)) {
                    stack.push(ch);
                } // 스택이 비어있지 않으면서, 닫는 괄호인 ch와 stack이 연결된 관계면
                else if (!stack.isEmpty() && map.get(ch) == stack.peek()) {
                    stack.pop();
                } else {
                    isOK = false;
                    break;
                }
            }

            // 출력
            if(isOK){
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }

		}
	}
}