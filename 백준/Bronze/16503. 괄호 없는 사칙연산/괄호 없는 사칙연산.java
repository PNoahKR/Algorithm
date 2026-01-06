import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 파싱: 숫자 -> 연산자 -> 숫자 -> 연산자 -> 숫자 순서
        int k1 = Integer.parseInt(st.nextToken());
        char op1 = st.nextToken().charAt(0);
        int k2 = Integer.parseInt(st.nextToken());
        char op2 = st.nextToken().charAt(0);
        int k3 = Integer.parseInt(st.nextToken());

        // 앞에서부터 순서대로 계산 ((k1 op1 k2) op2 k3)
        int result1 = calc(calc(k1, op1, k2), op2, k3);

        // 뒤쪽 먼저 계산 (k1 op1 (k2 op2 k3))
        int result2 = calc(k1, op1, calc(k2, op2, k3));

        // 작은 수 출력 후 큰 수 출력
        System.out.println(Math.min(result1, result2));
        System.out.println(Math.max(result1, result2));
    }

    // 사칙연산을 수행하는 함수
    public static int calc(int a, char op, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b; // 자바의 정수 나눗셈은 몫만 취하므로 문제 조건 충족
        }
        return 0;
    }
}