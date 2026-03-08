import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.weight, o.weight);
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        int start = Integer.parseInt(br.readLine()); // 시작 정점 번호

        // 그래프 및 거리 배열 초기화
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        
        Arrays.fill(dist, INF); // 거리는 모두 무한대로 설정
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.end;
            int nowDist = current.weight;

            // 이미 더 짧은 경로로 갱신되었다면 무시
            if (nowDist > dist[now]) continue;

            for (Node next : graph[now]) {
                int cost = dist[now] + next.weight;

                if (cost < dist[next.end]) {
                    dist[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }
    }
}