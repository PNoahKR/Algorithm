import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        // 원판의 개수
        int N = sc.nextInt();

        // 로직
        BigInteger count = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
        System.out.println(count);

        // 출력
        if(N < 21) {
            hanoi(N, '1', '3', '2');
            System.out.print(sb);
        }
    }

    public static void hanoi(int n, char from, char to, char via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(n - 1, from, via, to);    // n-1개를 경유지로
            sb.append(from).append(" ").append(to).append("\n"); // 가장 큰 원판 이동
            hanoi(n - 1, via, to, from);    // n-1개를 목적지로
        }
    }
}