import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger a = n.divide(m);
        BigInteger b = n.remainder(m);

        System.out.println(a);
        System.out.println(b);
    }
}