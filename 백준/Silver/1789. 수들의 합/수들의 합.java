import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        long sum = 0;
        long count = 0;

        for (long i = 1; ; i++) {
            sum += i;
            
            if (sum > S) {
                break;
            }

            count++;
        }

        System.out.println(count);
    }
}