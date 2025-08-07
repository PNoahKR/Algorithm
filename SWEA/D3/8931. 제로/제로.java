import java.util.ArrayDeque;
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
            // 영수증 개수
            int K = sc.nextInt();
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            // 로직
            // 1. 불러주는 영수증의 금액을 스택에 담아넣는다.
            // 2. 0을 부를 경우 pop()을 통해서 영수증 금액을 토해냄
            // 3. 0을 부를 경우 스택에 금액이 있음은 보장됨.
             
            // K만큼 순회
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                // 불러준 정수가 0일 경우 가장 최근 금액 빼기
                if(x == 0) {
                    stack.pop();
                } else { // 0이 아닌경우 스택에 쌓기
                    stack.push(x);
                }
            }
            // 총액 수를 담을 변수
            int total = 0;
            // 스택을 비워가며 총 액수 계산
            while(stack.size() != 0) {
                int x = stack.pop();
                total += x;
            }
             
             
            // 출력
            System.out.println("#" + test_case + " " + total);
        }
    }
}