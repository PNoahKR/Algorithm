import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    // N이 주어지면 N까지의 수 중 소수를 에라이어쩌고의 체로 소수를 걸러보고
    // 걸러진 소수를 모아서 i + (i+1) + (i+2) ... N이 보다 같거나 작을때 까지 해보거나...
    // 왼쪽 오른쪽 포인터를 옮겨가면서 확인해보는 방법? 효율이 얼마나 나올 지 모르겟군


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 단 N을 받아.
        int N = Integer.parseInt(br.readLine());

        // 연속된 소수의 합으로 나타낼수 있는 자연수는 소수인가?
        //primes = true => 소수 아님
        List<Integer> list = new ArrayList<>();
        boolean[] primes = new boolean[N + 1];
        primes[0] = primes[1] = true;

        // 오버플로우 가 나버린다ㅑ...
        for (int i = 2; i * i <= N; i++) {
            if(!primes[i]){
                for (long j = (long) i * i; j <= N; j += i) {
                    primes[(int)j] = true;
                }
            }
        }

        // 소수 집어넣기
        for (int i = 2; i <= N; i++){
            if(!primes[i]){
                list.add(i);
            }
        }

        // N이전까지의 소수를 구했으니 start, end 포인터를 만들어서 값들을... 어떻게 요리조리
        int result = 0;
        int sum = 0;
        int start = 0;
        int end = 0;

        while(true){
            // sum이 N보다 커지면
            if(sum > N) {
                sum -= list.get(start++);
            }
            // end포인트가 리스트의 끝에 도달하면
            else if (end == list.size()){
                break;
            }
            // sumdl N보다 작으면
            else {
                sum += list.get(end++);
            }
            // sum이 N과 같아지면
            if (sum == N) result++;
        }

        System.out.println(result);
    }
}
