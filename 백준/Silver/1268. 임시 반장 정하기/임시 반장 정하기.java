import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] student = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int grade = 0; grade < 5; grade++) {
                student[i][grade] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxSameClassCount = -1; 
        int leader = 0;
        
        for (int i = 0; i < N; i++) {
            int count = 0; 
            
            for (int j = 0; j < N; j++) {
                if (i == j) continue; 
                for (int grade = 0; grade < 5; grade++) {
                    if (student[i][grade] == student[j][grade]) {
                        count++;
                        break;
                    }
                }
            }
            
            if (count > maxSameClassCount) {
                maxSameClassCount = count;
                leader = i + 1;
            }
        }
        
        System.out.println(leader);
    }
}