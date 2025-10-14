import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트 케이스
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < t; test++) {
            //친구 관계 수 F
            int F = Integer.parseInt(br.readLine());

            // 네트워크 관계를 저장할 맵!
            Map<String, String> network = new HashMap<>();

            // 네트워크 크기 저장
            Map<String, Integer> size = new HashMap<>();

            StringTokenizer st;
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                
                sb.append(union(a, b, network, size)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static String find(String name , Map<String, String> network, Map<String, Integer> size) {
        // 맵에 이름이 없으면 자기 자신을 대장으로
        if (!network.containsKey(name)) {
            network.put(name, name);
            size.put(name, 1);
            return name;
        }

        // 대장이 자기 자신일 때
        if (network.get(name).equals(name)) {
            return name;
        }

        // 압축
        String root = find(network.get(name), network, size);
        network.put(name, root);
        return root;
    }

    private static int union(String a, String b, Map<String, String> network, Map<String, Integer> size) {
        String rootA = find(a, network, size);
        String rootB = find(b, network, size);

        if (!rootA.equals(rootB)) {
            network.put(rootB, rootA);
            size.put(rootA, size.get(rootA) + size.get(rootB));
        }
        return size.get(rootA);
    }
}
