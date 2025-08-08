import java.util.Scanner;
 
 
class Solution
{
    private static int pow(int n, int m) {
        if(m == 1) {
            return n;
        }
        return n * pow(n, --m);
    }
     
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
         
        for (int t = 1; t <= 10; t++) {
            int test_case = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            System.out.println("#" + test_case + " " + pow(N, M));
        }
    }
}