import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, board);
        System.out.println(max);
    }

    
    private static void dfs(int depth, int[][] board) {
        // 종료 조건
        if (depth == 5) {
            findMax(board);
            return;
        }

        // 4방향 탐색
        for (int dir = 0; dir < 4; dir++) {
            // 복사본 생성
            int[][] copiedBoard = copyBoard(board);
            
            // dir 방향으로 기울임
            tilt(copiedBoard, dir);
            
            dfs(depth + 1, copiedBoard);
        }
    }

    private static void tilt(int[][] board, int dir) {
        Queue<Integer> q = new LinkedList<>();

        if (dir == 0) { // 위
            for (int j = 0; j < N; j++) {
                // 0이 아닌 숫자들을 모두 큐에 담고 빈칸으로 만듦
                for (int i = 0; i < N; i++) {
                    if (board[i][j] != 0) {
                        q.offer(board[i][j]);
                        board[i][j] = 0;
                    }
                }

                int index = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    
                    if (board[index][j] == 0) { // 비어있으면 그냥 넣기
                        board[index][j] = val;
                    } else if (board[index][j] == val) { // 같은 숫자면 합치고 다음 칸으로
                        board[index][j] *= 2;
                        index++; 
                    } else { // 다른 숫자면 다음 칸에 넣기
                        index++;
                        board[index][j] = val;
                    }
                }
            }
        } 
        else if (dir == 1) { // 아래
            for (int j = 0; j < N; j++) {
                for (int i = N - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        q.offer(board[i][j]);
                        board[i][j] = 0;
                    }
                }
                int index = N - 1;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (board[index][j] == 0) board[index][j] = val;
                    else if (board[index][j] == val) {
                        board[index][j] *= 2;
                        index--;
                    } else {
                        index--;
                        board[index][j] = val;
                    }
                }
            }
        } 
        else if (dir == 2) { // 왼쪽
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] != 0) {
                        q.offer(board[i][j]);
                        board[i][j] = 0;
                    }
                }
                int index = 0;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (board[i][index] == 0) board[i][index] = val;
                    else if (board[i][index] == val) {
                        board[i][index] *= 2;
                        index++;
                    } else {
                        index++;
                        board[i][index] = val;
                    }
                }
            }
        } 
        else if (dir == 3) { // 오른쪽
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    if (board[i][j] != 0) {
                        q.offer(board[i][j]);
                        board[i][j] = 0;
                    }
                }
                int index = N - 1;
                while (!q.isEmpty()) {
                    int val = q.poll();
                    if (board[i][index] == 0) board[i][index] = val;
                    else if (board[i][index] == val) {
                        board[i][index] *= 2;
                        index--;
                    } else {
                        index--;
                        board[i][index] = val;
                    }
                }
            }
        }
    }

    // 2차원 배열 깊은 복사
    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }
        return copy;
    }

    private static void findMax(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
    }
}