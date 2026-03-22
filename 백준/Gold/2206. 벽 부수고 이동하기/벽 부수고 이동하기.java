import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int dist;
    int wall;

    public Node(int x, int y, int dist, int wall) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.wall = wall;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                return current.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1) {

                        if (current.wall == 0 && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            queue.offer(new Node(nx, ny, current.dist + 1, 1));
                        }
                    } 
                    else {
                        if (!visited[nx][ny][current.wall]) {
                            visited[nx][ny][current.wall] = true;
                            queue.offer(new Node(nx, ny, current.dist + 1, current.wall));
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}