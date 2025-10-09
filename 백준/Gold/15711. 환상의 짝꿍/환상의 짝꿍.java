import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    /////////////////////////////////////////////////////////////////////////////
    // 밀러-라빈 판별법에서 long 범위의 수를 100% 판별하기 위해 사용하는 소수 목록
    static final int[] witness = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
    /////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스가 있네용?
        int T = Integer.parseInt(br.readLine());
        // 정답을 담자
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            // A, B 둘다 각각 2조..가 범위니까 long을 써 받아보겠습니다!
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            // 진짜 이런거 싫은데 골드바흐의 추측을 써야 머리가 편안할 것 같다
            // 골드바흐씨의 추측에 따르면 2이상의 짝수는 두 소수의 합으로 나타낼 수 있다라는 강한 추측이 있다.
            // 이 추측을 근거로 짝수라면 바로 YES를 출력해주면된다. 근데 만약 홀수라면?
            // 짝수 + 홀수 = 홀수 라고 생각했을 때, 짝수가 2여만 한다. 그리고 홀수가 소수인지 판변해야한다.
            // -> 2 이외의 짝수는 2로 나눠지기 때문에 소수일 수 없음 소수중 유일한 짝수는 2

            // 그렇다면 홀수 일 경우 A+B값에서 2을 뺀 값 x의 소수판별을 진행하면 될듯!
            // 테스트 케이스도 있고 4조-2 까지의 범위니까 계산된 것들은 static하게 저장해보자

            long sum = A + B;

            // 예외 케이스
            if(sum == 2) {
                sb.append("NO");
            }
            // 짝수일 때
            else if(sum % 2 == 0) {
                sb.append("YES");
            }
            // 홀수일 때
            else {
                long x = sum - 2;
                if(isPrime(x)){
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
            }

            sb.append("\n");

        }
        System.out.println(sb);
    }

    private static boolean isPrime(long x) {
//        // 1. 2보다 작은 수는 소수가 아님
//        if (x < 2) {
//            return false;
//        }
//        // 2. 2는 유일한 짝수 소수
//        if (x == 2) {
//            return true;
//        }
//        // 3. 2를 제외한 모든 짝수는 소수가 아님
//        if (x % 2 == 0) {
//            return false;
//        }
//        // 4. 3부터 sqrt(x)까지의 홀수들로만 나누어본다
//        // i*i <= x 는 i <= sqrt(x) 와 동일하며, 오버플로우에 더 안전하다.
//        for (long i = 3; i * i <= x; i += 2) {
//            // 나누어 떨어지면 소수가 아님
//            if (x % i == 0) {
//                return false;
//            }
//        }
//        // 5. 위 모든 검사를 통과하면 소수임
//        return true;
        /////////////////////////////////////////////////////////////////////////////
        if (x < 2) return false;

        BigInteger N = BigInteger.valueOf(x);

        for (long a : witness) {
            if (x == a) return true;

            BigInteger A = BigInteger.valueOf(a);
            if (!millerRabinTest(N, A)) return false;
        }
        return true;
        /////////////////////////////////////////////////////////////////////////////
    }

    /**
     * 밀러-라빈 테스트의 핵심 로직
     */
    private static boolean millerRabinTest(BigInteger n, BigInteger a) {
        BigInteger n_minus_1 = n.subtract(BigInteger.ONE);

        // n-1 = d * 2^s 를 만족하는 d, s 찾기
        BigInteger d = n_minus_1;
        int s = 0;
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            d = d.divide(BigInteger.TWO);
            s++;
        }

        // a^d mod n 계산
        BigInteger x = a.modPow(d, n);

        if (x.equals(BigInteger.ONE) || x.equals(n_minus_1)) {
            return true; // 소수일 가능성 높음
        }

        for (int r = 1; r < s; r++) {
            x = x.modPow(BigInteger.TWO, n);
            if (x.equals(n_minus_1)) {
                return true; // 소수일 가능성 높음
            }
        }

        return false; // 합성수
    }
}
