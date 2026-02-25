import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {

    static long C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long A, long B) {
        // B가 1일 경우 A^1
        if(B == 1) return A % C;

        // 지수법칙 A^{B+C} = A^B * A^C
        // 지수인 B의 절반인 A^{B/2} 를 구한다.
        long tmp = pow(A, B / 2);

        // 지수가 홀수라면 A를 한번 더 곱해줘야함
        if(B % 2 == 1) {
            return (tmp * tmp % C) * A % C;
        }

        return tmp * tmp % C;
    }
}