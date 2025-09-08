import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //1~n 까지의 수열

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] stack = new int[n]; //스택 배열

        int record = 0; //스택의 마지막 순번
        int start = 0; //스택의 마지막 입력값

        for (int i = 0; i < n; i++) {
            if (arr[i] > start) {
                for (int j = start + 1; j <= arr[i]; j++) { //start + 1(1) 부터 입력받은 값까지 push
                    stack[record] = j;
                    record++;
                    sb.append('+').append('\n');
                }
                start = arr[i]; //스택의 마지막 입력값으로 초기화
            } else if (stack[record - 1] != arr[i]) { //스택의 젤 위의 값이 입력받은 값과 일치하지 않는 경우
                System.out.print("NO");
                return;
            }
            sb.append('-').append('\n');
            record--; //pop 진행 후 순번 내리기
        }

        System.out.print(sb);
    }
}