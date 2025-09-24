import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // M과 N입력 받기
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 이번에는 boolean으로 하겠음
        boolean[] isNotPrime = new boolean[N + 1];

        // 0과 1 제외
        isNotPrime[0] = isNotPrime[1] = true;

        // 이번에는 굳이 max 값을 찾을 필요가 없다
        // N까지 니까 N까지의 소수를 찾자
        for (int i = 2; i * i <= N; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
