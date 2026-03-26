import java.io.*;

public class Main {
    
    static final long MOD = 1000000007;
    static final long[][] origin = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        // N이 0일 때의 예외 처리
        if (N == 0) {
            System.out.println(0);
            return;
        }

        long[][] result = pow(origin, N);

        System.out.println(result[0][1]);
    }

    // 거듭제곱 분할 정복 메서드
    static long[][] pow(long[][] A, long exp) {
        // 지수가 1이면 자기 자신을 그대로 반환
        if (exp == 1) {
            return A;
        }

        // 지수를 절반으로 나누어 재귀 호출
        long[][] half = pow(A, exp / 2);

        // 그 둘을 곱함
        long[][] temp = multiply(half, half);

        // 지수가 홀수였다면 기본 행렬을 한 번 더 곱해줌
        if (exp % 2 == 1) {
            return multiply(temp, origin);
        } else {
            return temp;
        }
    }

    // 2x2 행렬의 곱셈 메서드
    static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    // 오버플로우 방지
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }
        return ret;
    }
}