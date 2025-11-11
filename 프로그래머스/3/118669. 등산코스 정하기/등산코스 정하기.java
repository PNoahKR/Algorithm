import java.util.*;

class Solution {
    
    static class Edge {
        int to;
        int cost;
        
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    
    static class Node implements Comparable<Node> {
        int to;
        int intensity;
        
        public Node(int to, int intensity) {
            this.to = to;
            this.intensity = intensity;
        }
        
        @Override
        public int compareTo(Node o) {
            if(this.intensity != o.intensity) {
                return Integer.compare(this.intensity, o.intensity);
            }
            return Integer.compare(this.to, o.to);
        }
    }
    
    List<Edge>[] adj;
    boolean[] isGate;
    boolean[] isSummit;
    int[] intensity;
    static final int INF = Integer.MAX_VALUE;
    
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        adj = new ArrayList[n + 1];
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        intensity = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        Arrays.fill(intensity, INF);
        
        for (int gate : gates) isGate[gate] = true;
        for (int summit : summits) isSummit[summit] = true;
        
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int cost = path[2];

            adj[u].add(new Edge(v, cost));
            adj[v].add(new Edge(u, cost));
        }
        

        dijkstra(gates);
        
        int bestSummit = -1;
        int minIntensity = INF;


        Arrays.sort(summits); 
        
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                bestSummit = summit;
            }

        }
        
        return new int[]{bestSummit, minIntensity};
    }
    
    private void dijkstra(int[] gates) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            intensity[gate] = 0;
        }
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.to;
            int currentIntensity = current.intensity;

            if (currentIntensity > intensity[u]) {
                continue;
            }

            if (isSummit[u]) {
                continue;
            }

            for (Edge neighbor : adj[u]) {
                int v = neighbor.to;
                int edgeCost = neighbor.cost;
                
                if (isGate[v]) {
                    continue;
                }
                
                int newIntensity = Math.max(currentIntensity, edgeCost);
                
                if (newIntensity < intensity[v]) {
                    intensity[v] = newIntensity;
                    pq.add(new Node(v, newIntensity));
                }
            }
        }
    }
}