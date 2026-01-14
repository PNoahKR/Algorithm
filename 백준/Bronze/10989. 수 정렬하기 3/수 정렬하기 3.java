import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 카운팅정렬을 위한 배열 생성
        int[] count = new int[10001]; // 주어진 수의 범위가 1~10,000 까지니 10,001개의 배열 준비

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            count[x]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++){
            while(count[i]-- > 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
