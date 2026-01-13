import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] arr = new double[N];

        double max = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            max = Math.max(arr[i], max);
        }

        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += (arr[i] / max * 100);
        }

        System.out.println(sum/N);
    }
}
