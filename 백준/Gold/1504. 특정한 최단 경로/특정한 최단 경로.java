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

    static final int INF = 200000000;
    static int N, E;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 방향성이 없는 그래프
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 세 개의 점에서 출발
        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        // 두 가지 경로의 거리 계산
        // 1 -> v1 -> v2 -> N
        long routeA = distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        
        // 1 -> v2 -> v1 -> N
        long routeB = distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long answer = Math.min(routeA, routeB);

        if (answer >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int now = current.end;
            int nowDist = current.weight;

            if (nowDist > dist[now]) continue;

            for (Node next : graph[now]) {
                int cost = dist[now] + next.weight;
                if (cost < dist[next.end]) {
                    dist[next.end] = cost;
                    pq.offer(new Node(next.end, cost));
                }
            }
        }
        return dist;
    }
}