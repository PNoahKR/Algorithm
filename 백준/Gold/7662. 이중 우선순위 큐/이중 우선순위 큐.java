import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테케
        for (int test = 0; test < T; test++) {
            int k = Integer.parseInt(br.readLine()); // 연산의 개수

            // TreeMap: Key 기준으로 자동 오름차순 정렬됨
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    // 삽입: 이미 있으면 개수 +1, 없으면 1
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    // 삭제 연산
                    if (map.isEmpty()) continue;
                    int key;
                    // D 1 : 최댓값 삭제 -> lastKey()
                    // D -1 : 최솟값 삭제 -> firstKey()
                    if (n == 1) {
                        key = map.lastKey();
                    } else {
                        key = map.firstKey();
                    }

                    int count = map.get(key);
                    if (count == 1) {
                        map.remove(key); // 1개였으면 아예 삭제
                    } else {
                        map.put(key, count - 1); // 여러 개였으면 개수만 감소
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }

        }
        System.out.println(sb);
    }
}