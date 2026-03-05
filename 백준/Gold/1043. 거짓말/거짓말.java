import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());

        List<Integer> truthKnowers = new ArrayList<>(); // 진실을 아는 사람들

        for (int i = 0; i < truthCount; i++) {
            truthKnowers.add(Integer.parseInt(st.nextToken()));
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int partySize = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();

            int firstPerson = Integer.parseInt(st.nextToken());
            party.add(firstPerson);

            for (int j = 1; j < partySize; j++) {
                int nextPerson = Integer.parseInt(st.nextToken());
                party.add(nextPerson);
                // 첫 사람 기준으로 모두 묶기
                union(firstPerson, nextPerson);
            }
            parties.add(party);
        }

        int answer = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            int partyRep = party.get(0); // 파티의 대표 한 명만 확인

            // 진실을 아는 사람 중 한 명이라도 같은 그룹에 속해있는지 확인
            for (int truthPerson : truthKnowers) {
                if (find(partyRep) == find(truthPerson)) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    // 최상위 부모 찾기 함수
    private static int find(int x) {
        if (parent[x] == x) return x;
        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    // 합치는 함수
    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 대표가 다르면 한쪽의 대표를 다른 쪽에 연결
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}