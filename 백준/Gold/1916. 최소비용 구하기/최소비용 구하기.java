import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class City implements Comparable<City> {
    int to;
    int cost;
    public City(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(City o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 도시 N개
        int N = Integer.parseInt(br.readLine());
        // 버스 개수 M개
        int M = Integer.parseInt(br.readLine());

        List<City>[] cities = new List[N+1];

        for(int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        // 버스 정보
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cities[from].add(new City(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = dijstra(start, N, cities);

        System.out.println(dist[end]);
    }

    private static int[] dijstra(int start, int N, List<City>[] cities) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<City> pq = new PriorityQueue<>();

        pq.add(new City(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            City cur = pq.poll();
            int curTo = cur.to;
            int curCost = cur.cost;

            if(curCost > dist[curTo]) {
                continue;
            }

            for(City c : cities[curTo]) {
                int nextTo = c.to;
                int nextCost = c.cost;
                if(dist[nextTo] > nextCost + curCost) {
                    dist[nextTo] = nextCost + curCost;
                    pq.add(new City(nextTo, dist[nextTo]));
                }
            }
        }
        return dist;
    }
}
