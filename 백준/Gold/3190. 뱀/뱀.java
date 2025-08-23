import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    // 우 하 좌 상 순으로
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        // 보드 크기
        int N = sc.nextInt();
        // 1행 1열 부터 시작하니 인덱스를 맞추기 위한 +1
        int[][] board = new int[N+1][N+1];
        // 사과의 개수
        int K = sc.nextInt();

        // 0: 빈공간, 1: 뱀, 2: 사과
        for (int i = 0; i < K; i ++) {
            board[sc.nextInt()][sc.nextInt()] = 2;
        }

        // 방향 변환 횟수
        int L = sc.nextInt();
        HashMap<Integer, Character> command = new HashMap<>();
        for (int i = 0; i < L; i ++) {
            command.put(sc.nextInt(), sc.next().charAt(0));
        }

        // 로직
        // 시간을 셀 변수
        int time = 0;
        // 뱀의 좌표를 넣을 Deque
        ArrayDeque<int[]> snake = new ArrayDeque<>();
        // 시작 위치
        snake.addFirst(new int[]{1, 1});
        board[1][1] = 1;

        int direction = 0;

        while(true) {
            time++;
            // Deque에 머리인 가장 앞의 값을 가져온다.
            int[] head = snake.getFirst();
            int nr = head[0] + dr[direction];
            int nc = head[1] + dc[direction];
            // 경계 밖을 벗어나거나, 자기 자신을 만났을 때 반복문 탈출
            if (nr < 1 || nr > N || nc < 1 || nc > N || board[nr][nc] == 1) {
                System.out.println(time);
                break;
            }
            // 사과를 발견하지 못했을 경우
            else if(board[nr][nc] == 0) {
                // Deque의 가장 뒷 값인 꼬리의 값을 가져와 지우고, 0으로 만들어준다.
                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = 0;
            }

            // 뱀의 머리좌표를 Deque의 가장 앞에 넣고 값도 1로 만들어준다.
            snake.addFirst(new int[]{nr, nc});
            board[nr][nc] = 1;

            // 만약 time이 맵에 있을때 방향을 전환해준다.
            if (command.containsKey(time) && command.get(time) == 'D') {
                direction = (direction + 1) % 4;
            } else if (command.containsKey(time) && command.get(time) == 'L') {
                direction = (direction + 3) % 4;
            }

        }
    }
}
