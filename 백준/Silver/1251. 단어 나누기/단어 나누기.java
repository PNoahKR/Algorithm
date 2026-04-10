import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        String answer = null;

        for (int i = 1; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {

                String part1 = word.substring(0, i);
                String part2 = word.substring(i, j);
                String part3 = word.substring(j, len);

                StringBuilder sb1 = new StringBuilder(part1).reverse();
                StringBuilder sb2 = new StringBuilder(part2).reverse();
                StringBuilder sb3 = new StringBuilder(part3).reverse();

                String result = sb1.toString() + sb2.toString() + sb3.toString();

                if (answer == null || result.compareTo(answer) < 0) {
                    answer = result;
                }
            }
        }

        System.out.println(answer);
    }
}