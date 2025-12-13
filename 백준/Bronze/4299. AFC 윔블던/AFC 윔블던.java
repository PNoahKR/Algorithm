import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());

        if(sum < diff){
            System.out.println(-1);
        }

        else if (( sum + diff ) % 2 != 0){
            System.out.println(-1);
        }

        else {
            int x = (sum + diff) / 2;
            int y = (sum - diff) / 2;
            System.out.println(x + " " + y);
        }
    }
}
