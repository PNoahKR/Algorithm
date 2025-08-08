import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
         
        for (int test_case = 1; test_case <= 10; test_case++) {
            // 입력
            int N = sc.nextInt();
            char[] arr = new char[N];
             
            arr = sc.next().toCharArray();
             
            ArrayDeque<Character> stack1 = new ArrayDeque<>(); // 중위 -> 후위
            ArrayDeque<Integer> stack2 = new ArrayDeque<>(); // 중위 -> 후위
             
            StringBuilder sb = new StringBuilder();
            // 로직
            for (char c : arr) {
                if(Character.isDigit(c)) {
                    sb.append(c);
                } else {
                    while(!stack1.isEmpty()) {
                        sb.append(stack1.pop());
                    }
                    stack1.push(c);
                }
            }
             
            for (char c : String.valueOf(sb).toCharArray()) {
                if(Character.isDigit(c)) {
                    stack2.push(c - '0');
                } 
                while (stack2.size() > 1){
                    int b = stack2.pop();
                    int a = stack2.pop();
                    stack2.push(a + b);
                }
            }
             
             
             
            // 출력
            System.out.println("#" + test_case + " " + stack2.pop());
             
        }
    }
}