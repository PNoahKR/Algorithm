import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> numToName = new HashMap<>();
        Map<String, Integer> nameToNum = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            numToName.put(i, input);
            nameToNum.put(input, i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            String value = br.readLine();
            try {
                int num = Integer.parseInt(value);
                sb.append(numToName.get(num)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(nameToNum.get(value)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
