import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N!의 N 입력
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        // 5로 계속 나누면서 누적 (5, 25, 125, ...)
        // 예: N=100 이라면
        // i=5일 때: 100/5 = 20개 추가
        // i=25일 때: 100/25 = 4개 추가
        // i=125일 때: 반복 종료
        // 총 24개
        while (N >= 5) {
            count += N / 5;
            N /= 5;
        }

        System.out.println(count);
    }
}
