import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        
        dfs(0);
        
        System.out.println(count);
    }

    private static void dfs(int depth) {
        
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            
            if (isSafe(depth)) {
                dfs(depth + 1);
            }
        }
    }

    private static boolean isSafe(int row) {
        for (int i = 0; i < row; i++) {
            
            if (arr[row] == arr[i]) {
                return false;
            }
            
            else if (Math.abs(row - i) == Math.abs(arr[row] - arr[i])) {
                return false;
            }
        }
        return true; 
    }
}