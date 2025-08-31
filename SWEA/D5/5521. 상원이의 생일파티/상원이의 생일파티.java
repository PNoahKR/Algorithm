import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 친구의 수
            N = Integer.parseInt(st.nextToken());
            // 관계의 수
            int M = Integer.parseInt(st.nextToken());

            List<List<Integer>> friends = new ArrayList<>();

            // N명의 사람 수 만큼 리스트 인덱스 추가!
            // 0 은 안쓸거야~!
            for (int i = 0; i <= N; i++) {
                friends.add(new ArrayList<>());
            }
            // M개의 a, b 관계를 넣어
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 양방향 관계
                friends.get(a).add(b);
                friends.get(b).add(a);
            }
            // 로직



            // 출력
            System.out.println("#" + test_case + " " + bfs(friends));

        } // tc반복문
    }

    public static int bfs(List<List<Integer>> friends) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        q.add(new int[]{1, 0}); // 상원이 넣기
        visited[1] = true;

        int birthdayParty = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int people = cur[0];
            int depth = cur[1];

            if (depth >= 2) {
                continue;
            }

            for (int friend : friends.get(people)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    birthdayParty++;
                    q.add(new int[]{friend, depth+1});
                }
            }
        }

        return birthdayParty;
    }
}
