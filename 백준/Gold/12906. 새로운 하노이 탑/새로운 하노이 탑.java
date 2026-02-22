import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class State {
        String[] pegs; // 3개의 막대 상태
        int moves;     // 이동 횟수

        public State(String[] pegs, int moves) {
            this.pegs = pegs;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] startPegs = new String[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            if (count > 0) {
                startPegs[i] = st.nextToken();
            } else {
                startPegs[i] = "";
            }
        }

        System.out.println(bfs(startPegs));
    }

    static int bfs(String[] startPegs) {
        Queue<State> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(new State(startPegs, 0));
        visited.add(makeStateString(startPegs));

        while (!queue.isEmpty()) {
            State current = queue.poll();
            String[] p = current.pegs;

            if (isAnswer(p)) {
                return current.moves;
            }

            for (int i = 0; i < 3; i++) {
                // i번 막대에 원판이 있다면
                if (p[i].length() > 0) {
                    // 맨 위 원판 빼기
                    String nextBase = p[i].substring(0, p[i].length() - 1);
                    char topDisk = p[i].charAt(p[i].length() - 1);

                    // 다른 막대로 옮기기
                    for (int j = 0; j < 3; j++) {
                        if (i == j) continue;

                        String[] nextPegs = p.clone();
                        nextPegs[i] = nextBase;
                        nextPegs[j] = p[j] + topDisk;

                        String nextStateStr = makeStateString(nextPegs);

                        if (!visited.contains(nextStateStr)) {
                            visited.add(nextStateStr);
                            queue.add(new State(nextPegs, current.moves + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    // 방문 체크용
    static String makeStateString(String[] p) {
        return p[0] + "/" + p[1] + "/" + p[2];
    }

    static boolean isAnswer(String[] p) {
        for (int i = 0; i < p[0].length(); i++) {
            if (p[0].charAt(i) != 'A') return false;
        }
        for (int i = 0; i < p[1].length(); i++) {
            if (p[1].charAt(i) != 'B') return false;
        }
        for (int i = 0; i < p[2].length(); i++) {
            if (p[2].charAt(i) != 'C') return false;
        }
        return true;
    }
}