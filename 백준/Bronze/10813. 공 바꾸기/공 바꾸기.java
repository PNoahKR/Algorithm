import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바구니 개수
        int M = Integer.parseInt(st.nextToken()); // 바꾸는 횟수

        int[] basket = new int[N];
        
        for (int i = 0; i < N; i++) {
            basket[i] = i + 1;
        }

        // M번 공 교환
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // 배열 인덱스는 0부터 시작하므로 입력값에서 1을 빼줌
            int idx1 = i - 1;
            int idx2 = j - 1;

            // temp 변수를 이용해 두 값을 교환
            int temp = basket[idx1];
            basket[idx1] = basket[idx2];
            basket[idx2] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int ball : basket) {
            sb.append(ball).append(" ");
        }
        System.out.println(sb);
    }
}