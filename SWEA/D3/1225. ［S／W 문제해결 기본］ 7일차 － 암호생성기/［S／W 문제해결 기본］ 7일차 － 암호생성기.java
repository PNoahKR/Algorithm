import java.util.LinkedList;
import java.util.Queue;
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
            int T = sc.nextInt();
 
            // 배열 생성
            Queue<Integer> q = new LinkedList<>();
 
            // 데이터 넣기
            for (int i = 0; i < 8; i++) {
                q.add(sc.nextInt());
            }
 
            // 로직
            // 0이 발견되면 while문 탈출
            boolean zero = false;
            while (!zero) {
                // 1~5까지 사이클을 돌면서 감수
                for (int i = 1; i < 6; i++) {
                    int num = q.poll();
                    num -= i;
                    if (num <= 0) {
                        q.offer(0);
                        zero = true;
                        break;
                    }
                    q.offer(num);
                }
            }
 
            // 출력
            System.out.print("#" + T + " ");
            for (int p : q) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}