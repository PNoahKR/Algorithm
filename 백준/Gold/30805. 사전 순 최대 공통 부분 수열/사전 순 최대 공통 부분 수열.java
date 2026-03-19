import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> answer = new ArrayList<>();
        
        
        int idxA = 0;
        int idxB = 0;

        for (int target = 100; target >= 1; target--) {
            
            while (true) {
                int posA = -1;
                int posB = -1;

                for (int i = idxA; i < N; i++) {
                    if (A[i] == target) {
                        posA = i;
                        break; // 가장 처음 나온 것을 선택
                    }
                }

                for (int i = idxB; i < M; i++) {
                    if (B[i] == target) {
                        posB = i;
                        break;
                    }
                }

                if (posA != -1 && posB != -1) {
                    answer.add(target);
                    idxA = posA + 1;
                    idxB = posB + 1;
                } else {
                    break;
                }
            }
        }

        System.out.println(answer.size());
        if (!answer.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int val : answer) {
                sb.append(val).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}