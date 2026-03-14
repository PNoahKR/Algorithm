import java.io.*;
import java.util.*;

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {

    static int N;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxDist = 0;  
    static int farNodeNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 노드가 1개일 때는 간선이 없으므로 지름은 무조건 0
        if (N == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        // 첫 번째 DFS: 1번 노드에서 가장 먼 노드 찾기
        visited = new boolean[N + 1];
        dfs(1, 0);

        // 두 번째 DFS: 찾은 가장 먼 노드에서 다시 가장 먼 거리 찾기
        visited = new boolean[N + 1]; // 방문 배열 초기화
        maxDist = 0;                  // 거리 0부터 재기
        dfs(farNodeNum, 0);

        System.out.println(maxDist);
    }

    private static void dfs(int current, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farNodeNum = current;
        }
        
        visited[current] = true;

        for (Node next : tree[current]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}