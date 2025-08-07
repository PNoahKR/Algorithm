import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
 
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
            // 괄호
            String str = sc.next();
            // 괄호를 담을 스택
            Stack<Character> stack = new Stack<>();
            // 잘린 쇠막대기
            int cutStick = 0;
            // 레이저 생성 조건
            boolean raser = false;
 
            // 로직
            /*
             * 1. 앞에서 부터 천천히 순회 2. '(' 를 만나면 stack에 push(), raser = true 3. ')'를 만나면 stack에
             * pop() 3-1. raser가 true이면 stack.size() 만큼 cutStick에 더하기, raser = false 3-2.
             * raser가 false이면 cutStick에 + 1
             */
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push(str.charAt(i));
                    raser = true;
                } else {
                    stack.pop();
                    if (raser) {
                        cutStick += stack.size();
                        raser = false;
                    } else {
                        cutStick++;
                    }
                }
            }
 
            // 출력
            System.out.println("#" + test_case + " " + cutStick);
        }
    }
}