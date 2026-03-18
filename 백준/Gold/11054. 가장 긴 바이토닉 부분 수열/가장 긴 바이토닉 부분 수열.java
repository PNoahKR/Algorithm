import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        int[] dpLR = new int[n]; // 왼오
        int[] dpRL = new int[n]; // 오왼

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 왼쪽에서 오른쪽
        for (int i = 0; i < n; i++) {
            dpLR[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dpLR[i] = Math.max(dpLR[i], dpLR[j] + 1);
                }
            }
        }

        // 오른쪽에서 왼쪽
        for (int i = n - 1; i >= 0; i--) {
            dpRL[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dpRL[i] = Math.max(dpRL[i], dpRL[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            // 정방향 길이 + 역방향 길이 - 1
            int currentLen = dpLR[i] + dpRL[i] - 1;
            maxLen = Math.max(maxLen, currentLen);
        }

        System.out.println(maxLen);
    }
}