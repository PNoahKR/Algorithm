import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열의 길이 N
        N = Integer.parseInt(br.readLine());

        result = "";
        // 숫자를 하나씩 만들어보자
        putNum("");

        System.out.println(result);
    }

    private static void putNum(String num) {
        // result의 값이 채워졌다면 걍 return 때려
        if(!result.isEmpty()) return;

        //num이라는 수열의 길이가 N이 된다면
        if(num.length() == N) {
            result = num;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            //숫자를 1, 2, 3 순으로 다 넣어보기
            String nextNum = num + i;
            // 좋은 수열 판별 로직
            if(isOk(nextNum)){
                putNum(nextNum);
            }
        }
    }

    // 좋은수열 판별 로직
    // 인접한 두개의 부분 수열이 동일하다면 나쁜거니까 N/2길이 까지만 확인해보면 된다
    // 1, 2, 3 ... N/2 까지 확인해보자
    // 로직을 구상하다 보니 결국 길이가 1개일때 판독 2일때 판독 3일때 판독 하면서 이미 앞은 좋은 수열일 것?
    // 그럼 뒤에서 부터 1~nextNum/2 까지만판별하면된다..!
    private static boolean isOk(String nextNum) {
        for (int i = 1; i <= nextNum.length()/2; i++) {
            String right = nextNum.substring(nextNum.length()-i);
            String left = nextNum.substring(nextNum.length()-2*i, nextNum.length()-i);

            if(left.equals(right)) {
                return false;
            }
        }
        return true;
    }
}
