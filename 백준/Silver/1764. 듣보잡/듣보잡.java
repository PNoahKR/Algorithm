
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 듣도
        int N = Integer.parseInt(st.nextToken());
        // 보도
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();

            if(set.contains(name)) {
                result.add(name);
            }
        }

        // 사전 순 정렬
        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for (String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
