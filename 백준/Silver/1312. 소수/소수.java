import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int remainder = A % B;
        int result = 0;

        for(int i = 0; i < N; i++){
            remainder *= 10;
            result = remainder / B;
            remainder %= B;
        }

        System.out.println(result);
    }
}