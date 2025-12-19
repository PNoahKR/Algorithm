import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int test_case = 1; test_case <= 10; test_case++) {
            // 입력
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 로직
            // 출력
            System.out.println("#" + T + " " + pow(N, M));

        } // tc반복문
        sc.close();
    }

    private static int pow(int n, int m) {
        if(m == 1) {
            return n;
        }
        return n * pow(n, m - 1);
    }
}
