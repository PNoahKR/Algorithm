import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] parent;
    static List<List<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        visited = new boolean[n+1];
        parent = new int[n+1];
        
        for(int i = 0; i <= n; i++){
            arr.add(new ArrayList<>());
        }
        
        StringTokenizer st;
        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dfs(1);

        for (int i = 2; i <= n; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        for(int num : arr.get(start)) {
            if(!visited[num]) {
                dfs(num);
                parent[num] = start;
            }
        }
    }
}