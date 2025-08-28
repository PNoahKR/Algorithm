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
            // 마지막부터 N개의 비트 수 
            int N = sc.nextInt();
            // 이진수로 표현할 M
            int M = sc.nextInt();
            // 로직
            // 1. 짝수면 OFF
            if(M % 2 == 0) {
                System.out.println("#" + test_case + " OFF");
                continue;
            }
             
            int mask = (1 << N) - 1;
             
            if((M & mask) == mask) {
                System.out.println("#" + test_case + " ON");                
            } else {                
                System.out.println("#" + test_case + " OFF");               
            }
        }
    }
}