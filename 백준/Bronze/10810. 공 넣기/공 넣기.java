import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 바구니 개수, M: 공을 넣는 횟수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 바구니 배열 생성 (기본값은 0으로 초기화됨)
        // 문제에서 바구니 번호는 1번부터 시작하므로, 
        // 0번 인덱스를 1번 바구니로 생각하거나, 크기를 N+1로 만들어도 됩니다.
        // 여기서는 크기 N으로 만들고 인덱스를 보정하겠습니다.
        int[] basket = new int[N];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); // 시작 바구니
            int j = Integer.parseInt(st.nextToken()); // 끝 바구니
            int k = Integer.parseInt(st.nextToken()); // 공 번호

            // i번 바구니부터 j번 바구니까지 k번 공을 넣음
            // 배열 인덱스는 0부터 시작하므로 입력받은 번호에서 -1을 해줘야 함
            for (int idx = i - 1; idx < j; idx++) {
                basket[idx] = k; // 기존 값을 k로 덮어씀
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : basket) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}