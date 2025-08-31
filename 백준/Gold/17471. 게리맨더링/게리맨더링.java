import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {

    static int N;
    static int[] population;
    static List<Integer>[] area;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        area = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            area[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                area[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }
        List<Integer> groupA = new ArrayList<>();
        divideArea(0, groupA);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    public static void divideArea(int index, List<Integer> groupA) {
        if (index == N) {
            if (groupA.isEmpty() || groupA.size() == N) return;

            List<Integer> groupB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (!groupA.contains(i)) {
                    groupB.add(i);
                }
            }

            if (isConnected(groupA) && isConnected(groupB)) {
                int popA = getPopulation(groupA);
                int popB = getPopulation(groupB);
                min = Math.min(min, Math.abs(popA - popB));
            }
            return;
        }

        groupA.add(index);
        divideArea(index + 1, groupA);

        groupA.remove(groupA.size() - 1);
        divideArea(index + 1, groupA);
    }

    public static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(group.get(0));
        visited[group.get(0)] = true;

        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : area[current]) {
                if (group.contains(neighbor) && !visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    visitedCount++;
                }
            }
        }

        return visitedCount == group.size();
    }

    public static int getPopulation(List<Integer> group) {
        int sum = 0;
        for (int idx : group) {
            sum += population[idx];
        }
        return sum;
    }
}