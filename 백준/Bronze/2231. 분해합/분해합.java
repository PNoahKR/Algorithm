import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strN = br.readLine();
        int N = Integer.parseInt(strN);
        int len = strN.length(); // 자릿수

        int result = 0;


        int start = N - (len * 9);
        if (start < 1) start = 1;

        for (int i = start; i < N; i++) {
            int number = i;
            int sum = 0;

            // 각 자릿수 더하기
            while (number != 0) {
                sum += number % 10;
                number /= 10;
            }

            // 분해합 검사
            if (sum + i == N) {
                result = i;
                break; // 가장 작은 생성자를 찾았으므로 즉시 종료
            }
        }

        System.out.println(result);
    }
}
