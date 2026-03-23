import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        start = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                // B가 1일 때는 제곱과정에서 A가 바로 반환될 수 있기 때문에
                // 행렬의 원소가 1000 이상일 경우 1000으로 나눈값이 바로 안나와서 미리 1000의 나머지값을 구함
                start[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(start, B);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i ++) {
            for(int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static int[][] pow(int[][] A, long b) {

        // b가 1일땐 A 반환
        if(b == 1L) {
            return A;
        }

        // 절반으로 분할해 재귀 호출
        int[][] ret = pow(A, b / 2);

        ret = multiply(ret, ret);

        if(b % 2 == 1L) {
            ret = multiply(ret, start);
        }

        return ret;
    }

    private static int[][] multiply(int[][] o1, int[][] o2) {
		
		int[][] ret = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= 1000;	// 행렬 원소 연산이 끝나면 나머지연산
				}
			}
		}
		return ret;
	}
}